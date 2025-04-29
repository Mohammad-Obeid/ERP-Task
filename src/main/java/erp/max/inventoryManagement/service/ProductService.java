package erp.max.inventoryManagement.service;

import erp.max.inventoryManagement.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    ProductDTO getProductById(String id);
//    ProductDTO getProductByBarcode(String barcode);
    List<ProductDTO> getAllProducts(int page);
}
