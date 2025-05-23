package erp.max.inventoryManagement.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

@Table
@Entity
public class ProductMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false, name = "movement_date")
    private Timestamp movementDate;
    @Column(name = "to_location")
    private String toLocation;
    @Column(name = "from_location")
    private String fromLocation;
    @Column(nullable = false, name = "product_id")
    private String productId;
    @Column(nullable = false, name = "quantity")
    private int quantity;

    public ProductMovement() {
    }

    public ProductMovement(String id, Timestamp movementDate, String toLocation, String fromLocation, String productId, int quantity) {
        this.id = id;
        this.movementDate = Timestamp.from(Instant.now());
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
        this.movementDate = Timestamp.from(Instant.now());
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
