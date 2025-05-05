package erp.max.inventoryManagement.service;

import erp.max.inventoryManagement.JsonResponse.LocationProductsResponse;
import erp.max.inventoryManagement.JsonResponse.MoveResponse2;
import erp.max.inventoryManagement.JsonResponse.MovesResponse;
import erp.max.inventoryManagement.JsonResponse.ProductBalance;
import erp.max.inventoryManagement.dto.ProductMovementDTO;

import java.util.List;

public interface ProductMovementService {
    ProductMovementDTO getProductMovementById(String id);
    List<ProductBalance> getProductBalance(String id);
    MoveResponse2 getAllProductMovements(int page);
    MovesResponse getAllProductMovement(int page);
    ProductMovementDTO createProductMovement(ProductMovementDTO productMovementDTO);
    ProductMovementDTO updateProductMovement(ProductMovementDTO productMovementDTO);
    List<LocationProductsResponse> getLocationProducts(String id);
//    boolean deleteProductMovement(String id);
}
