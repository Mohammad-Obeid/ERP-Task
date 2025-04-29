package erp.max.inventoryManagement.service.implementation;

import erp.max.inventoryManagement.dto.ProductMovementDTO;
import erp.max.inventoryManagement.mapper.ProductMovementMapper;
import erp.max.inventoryManagement.model.ProductMovement;
import erp.max.inventoryManagement.repository.ProductMovementRepository;
import erp.max.inventoryManagement.repository.ProductRepository;
import erp.max.inventoryManagement.service.ProductMovementService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductMovementServiceImp implements ProductMovementService {
    private final ProductMovementRepository productRepo;

    public ProductMovementServiceImp(ProductMovementRepository productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public ProductMovementDTO getProductMovementById(String id) {
        Optional<ProductMovement> product = productRepo.findById(id);
        if(product.isEmpty())return null;
        return ProductMovementMapper.mapToDTO(product.get());
    }

    @Override
    public List<ProductMovementDTO> getAllProductMovements(int page) {
        return productRepo.findAll(PageRequest.of(page,5))
                .map(ProductMovementMapper::mapToDTO).stream().toList();
    }


    @Override
    public ProductMovementDTO createProductMovement(ProductMovementDTO productMovementDTO) {
        ProductMovement move = productRepo.save(ProductMovementMapper.mapToEntity(productMovementDTO));
        return ProductMovementMapper.mapToDTO(move);
    }

    @Override
    public ProductMovementDTO updateProductMovement(ProductMovementDTO productMovementDTO) {
        Optional<ProductMovement> product = productRepo.findById(productMovementDTO.getId());
        if(product.isEmpty())return null;
        productMovementDTO.setProductId(product.get().getProductId());
        productRepo.save(ProductMovementMapper.mapToEntity(productMovementDTO));
        return productMovementDTO;
    }



//    @Override
//    public boolean deleteProductMovement(String id) {
//        return false;
//    }

}
