package erp.max.inventoryManagement.service.implementation;

import erp.max.inventoryManagement.JsonResponse.LocationProductsResponse;
import erp.max.inventoryManagement.JsonResponse.MoveResponse2;
import erp.max.inventoryManagement.JsonResponse.MovesResponse;
import erp.max.inventoryManagement.JsonResponse.ProductBalance;
import erp.max.inventoryManagement.dto.ProductMovementDTO;
import erp.max.inventoryManagement.mapper.ProductMovementMapper;
import erp.max.inventoryManagement.model.Product;
import erp.max.inventoryManagement.model.ProductMovement;
import erp.max.inventoryManagement.repository.LocationRepository;
import erp.max.inventoryManagement.repository.ProductMovementRepository;
import erp.max.inventoryManagement.repository.ProductRepository;
import erp.max.inventoryManagement.service.ProductMovementService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductMovementServiceImp implements ProductMovementService {
    private final ProductMovementRepository productRepo;
    private final ProductRepository prodRepo;
    private final LocationRepository locRepo;
    public ProductMovementServiceImp(ProductMovementRepository productRepo, ProductRepository prodRepo, LocationRepository locRepo) {
        this.productRepo = productRepo;
        this.prodRepo = prodRepo;
        this.locRepo = locRepo;
    }


    @Override
    public ProductMovementDTO getProductMovementById(String id) {
        Optional<ProductMovement> product = productRepo.findById(id);
        if(product.isEmpty())return null;
        return ProductMovementMapper.mapToDTO(product.get());
    }

    //todo: develop this method
    @Override
    public List<ProductBalance> getProductBalance(String id) {
        Optional<List<ProductMovement>> prods = productRepo.findByProductId(id);

        return prods.map(productMovements -> productMovements.stream()
                .map(prod -> {
                    Product product = prodRepo.findById(prod.getProductId()).orElse(null);
                    String productName = product != null ? product.getProductName() : "Unknown";
                    return new ProductBalance(
                            productName,
                            prod.getToLocation(),
                            prod.getQuantity()
                    );
                })
                .toList()).orElseGet(List::of);
    }


    @Override
    public MovesResponse getAllProductMovement(int page) {
        List<Product> prods = prodRepo.findAll();
        long numOfPages = productRepo.count();
        numOfPages /= 5;
        List<ProductMovement> productMovements = productRepo.findAll();

        return new MovesResponse(productRepo.findAll(PageRequest.of(page,5))
                .map(ProductMovementMapper::mapToDTO).stream().toList(),page,numOfPages);
    }

    @Override
    public MoveResponse2 getAllProductMovements(int page) {
        List<Product> prods = prodRepo.findAll();

        // Build full list of product balances
        List<ProductBalance> res = new ArrayList<>();
        for (Product product : prods) {
            List<ProductBalance> prodB = getProductBalance(product.getId());
            for (ProductBalance productBalance : prodB) {
                if (productBalance.getProductName() != null) {
                    res.add(productBalance);
                }
            }
        }

        // Manual pagination
        int pageSize = 5;
        int start = page * pageSize;
        int end = Math.min(start + pageSize, res.size());
        List<ProductBalance> paginatedRes = res.subList(start, end);

        // Total number of pages
        long numOfPages = (res.size() + pageSize - 1) / pageSize; // ceil

        return new MoveResponse2(paginatedRes, page, numOfPages);
    }

    @Override
    public ProductMovementDTO createProductMovement(ProductMovementDTO productMovementDTO) {
        Optional<Product> prod = prodRepo.findById(productMovementDTO.getProductId());
        if(prod.isEmpty())return null;
        productMovementDTO.setMovementDate(Timestamp.from(Instant.now()));
        ProductMovement move = productRepo.save(ProductMovementMapper.mapToEntity(productMovementDTO));
        return ProductMovementMapper.mapToDTO(move);
    }

    @Override
    public ProductMovementDTO updateProductMovement(ProductMovementDTO productMovementDTO) {
        Optional<ProductMovement> productMove = productRepo.findById(productMovementDTO.getId());
//        Optional<Product> prod = prodRepo.findById(productMovementDTO.getProductId());
//        if(prod.isEmpty())return null;
//        if(productMove.isEmpty())return null;
        productMove.get().setProductId(productMovementDTO.getProductId());
        if(productMovementDTO.getFromLocation() != null)
            productMove.get().setFromLocation(productMovementDTO.getFromLocation());
        if(productMovementDTO.getToLocation() != null)
            productMove.get().setToLocation(productMovementDTO.getToLocation());
        productMove.get().setQuantity(productMovementDTO.getQuantity());
        productMove.get().setMovementDate(Timestamp.from(Instant.now()));
        productRepo.save(productMove.get());
        return ProductMovementMapper.mapToDTO(productMove.get());
    }

    @Override
    public List<LocationProductsResponse> getLocationProducts(String loc) {
        List<ProductMovement> prods = productRepo.findByToLocation(loc).orElse(Collections.emptyList());
        return prods.stream().map(prod ->
                new LocationProductsResponse(
                        prod.getId(),
                        prod.getProductId(),
                        prodRepo.findById(prod.getProductId()).get().getProductName(),
                        prod.getQuantity()
                )
        ).toList();
    }


//    @Override
//    public boolean deleteProductMovement(String id) {
//        return false;
//    }

}
