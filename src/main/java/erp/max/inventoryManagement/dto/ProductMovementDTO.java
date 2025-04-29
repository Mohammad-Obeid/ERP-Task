package erp.max.inventoryManagement.dto;
import java.sql.Timestamp;

public class ProductMovementDTO {
    private String id;
    private Timestamp movementDate;
    private String toLocation;
    private String fromLocation;
    private String productId;
    private String quantity;

    public ProductMovementDTO() {
    }

    public ProductMovementDTO(String id, Timestamp movementDate, String toLocation, String fromLocation, String productId, String quantity) {
        this.id = id;
        this.movementDate = Timestamp.from(movementDate.toInstant());
        this.toLocation = toLocation;
        this.fromLocation = fromLocation;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(Timestamp movementDate) {
        this.movementDate = Timestamp.from(movementDate.toInstant());
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
