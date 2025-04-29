package erp.max.inventoryManagement.mapper;

import erp.max.inventoryManagement.dto.ProductDTO;
import erp.max.inventoryManagement.model.Product;

public class ProductMapper {
    public static ProductDTO MapToDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getProductBarcode()
        );
    }
    public static Product MapToEntity(ProductDTO productDTO){
        return new Product(
                productDTO.getId(),
                productDTO.getProductName(),
                productDTO.getProductBarcode()
        );
    }
}
