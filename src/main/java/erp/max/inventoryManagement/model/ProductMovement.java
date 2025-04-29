package erp.max.inventoryManagement.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table
@Entity
public class ProductMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false, name = "movement_date")
    private Timestamp movementDate;
    @Column(nullable = false, name = "to_location")
    private String toLocation;
    @Column(nullable = false, name = "from_location")
    private String fromLocation;
    @Column(nullable = false, name = "product_id")
    private String productId;
    @Column(nullable = false, name = "quantity")
    private String quantity;

    public ProductMovement() {
    }

    public ProductMovement(String id, Timestamp movementDate, String toLocation, String fromLocation, String productId, String quantity) {
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
