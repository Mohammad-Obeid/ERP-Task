package erp.max.inventoryManagement.mapper;

import erp.max.inventoryManagement.dto.ProductMovementDTO;
import erp.max.inventoryManagement.model.ProductMovement;

public class ProductMovementMapper {
    public static ProductMovementDTO mapToDTO(ProductMovement productMove){
        return new ProductMovementDTO(
                productMove.getId(),
                productMove.getMovementDate(),
                productMove.getToLocation(),
                productMove.getFromLocation(),
                productMove.getProductId(),
                productMove.getQuantity()
        );
    }
    public static ProductMovement mapToEntity(ProductMovementDTO product){
        return new ProductMovement(
                product.getId(),
                product.getMovementDate(),
                product.getToLocation(),
                product.getFromLocation(),
                product.getProductId(),
                product.getQuantity()
        );
    }
}
//        String id, Timestamp movementDate, String toLocation, String fromLocation, String productId, String quantity