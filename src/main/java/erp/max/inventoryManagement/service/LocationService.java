package erp.max.inventoryManagement.service;

import erp.max.inventoryManagement.JsonResponse.LocationResponse;
import erp.max.inventoryManagement.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    LocationDTO getLocationById(String id);
    LocationDTO createLocation(LocationDTO locationDTO);
    LocationResponse getAllLocations(int page);
    boolean deleteLocation(String id);
}
