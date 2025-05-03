package erp.max.inventoryManagement.service.implementation;

import erp.max.inventoryManagement.JsonResponse.ProductResponse;
import erp.max.inventoryManagement.dto.ProductDTO;
import erp.max.inventoryManagement.mapper.ProductMapper;
import erp.max.inventoryManagement.model.Product;
import erp.max.inventoryManagement.model.ProductMovement;
import erp.max.inventoryManagement.repository.ProductMovementRepository;
import erp.max.inventoryManagement.repository.ProductRepository;
import erp.max.inventoryManagement.service.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository prodRepo;

    public ProductServiceImp(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }


    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Optional<Product> existingProduct = prodRepo.findByProductBarcode(productDTO.getProductBarcode());
        if(existingProduct.isPresent()){
            return null;
        }
        Product prod = prodRepo.save(ProductMapper.MapToEntity(productDTO));
        return ProductMapper.MapToDTO(prod);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Optional<Product> existingProduct = prodRepo.findById(productDTO.getId());
        if(existingProduct.isEmpty()){
            return null;
        }
        existingProduct.get().setProductName(productDTO.getProductName());
        Product updatedProduct = prodRepo.save(existingProduct.get());
        return ProductMapper.MapToDTO(updatedProduct);
    }

    @Override
    public ProductDTO getProductById(String id) {
        Optional<Product> existingProduct = prodRepo.findById(id);
        return existingProduct.map(ProductMapper::MapToDTO).orElse(null);
    }

//    @Override
//    public ProductDTO getProductByBarcode(String barcode) {
//        Optional<Product> existingProduct = prodRepo.findByProductBarcode(barcode);
//        return existingProduct.map(ProductMapper::MapToDTO).orElse(null);
//    }


    @Override
    public ProductResponse getAllProducts(int pageNum) {
        return new ProductResponse(prodRepo.findAll(PageRequest.of(pageNum, 6)).stream()
                .map(ProductMapper::MapToDTO)
                .toList(), pageNum);
    }
}
