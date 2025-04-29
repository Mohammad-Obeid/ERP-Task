package erp.max.inventoryManagement.mapper;

import erp.max.inventoryManagement.dto.LocationDTO;
import erp.max.inventoryManagement.model.Location;

public class LocationMapper {
    public static LocationDTO mapToDTO(Location location){
        return new LocationDTO(
                location.getId(),
                location.getLocationName(),
                location.getLocationCode()
        );
    }
    public static Location mapToEntity(LocationDTO locationDTO){
        return new Location(
                locationDTO.getId(),
                locationDTO.getLocationName(),
                locationDTO.getLocationCode()
        );
    }
}
