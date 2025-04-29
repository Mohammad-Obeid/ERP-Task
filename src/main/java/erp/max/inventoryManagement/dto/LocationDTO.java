package erp.max.inventoryManagement.dto;

import jakarta.persistence.Column;

public class LocationDTO {
    private String id;
    private String locationName;
    private String locationCode;

    public LocationDTO() {
    }

    public LocationDTO(String id, String locationName, String locationCode) {
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
