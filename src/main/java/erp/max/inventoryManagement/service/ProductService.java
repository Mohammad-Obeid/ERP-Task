package erp.max.inventoryManagement.service;

import erp.max.inventoryManagement.JsonResponse.ProductResponse;
import erp.max.inventoryManagement.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    ProductDTO getProductById(String id);
//    ProductDTO getProductByBarcode(String barcode);
    ProductResponse getAllProducts(int page);
}
