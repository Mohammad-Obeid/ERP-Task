package erp.max.inventoryManagement.model;

import jakarta.persistence.*;

@Table
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, name = "location_name")
    private String locationName;

    @Column(nullable = false, name = "location_code", unique = true)
    private String locationCode;

    public Location() {
    }

    public Location(String id, String locationName, String locationCode) {
        this.id = id;
        this.locationName = locationName;
        this.locationCode = locationCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
