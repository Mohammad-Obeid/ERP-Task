package erp.max.inventoryManagement.service;

import erp.max.inventoryManagement.dto.ProductMovementDTO;

import java.util.List;

public interface ProductMovementService {
    ProductMovementDTO getProductMovementById(String id);
    List<ProductMovementDTO> getAllProductMovements(int page);
    ProductMovementDTO createProductMovement(ProductMovementDTO productMovementDTO);
    ProductMovementDTO updateProductMovement(ProductMovementDTO productMovementDTO);
//    boolean deleteProductMovement(String id);
}
