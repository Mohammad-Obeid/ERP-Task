package erp.max.inventoryManagement.service.implementation;

import erp.max.inventoryManagement.JsonResponse.LocationResponse;
import erp.max.inventoryManagement.dto.LocationDTO;
import erp.max.inventoryManagement.mapper.LocationMapper;
import erp.max.inventoryManagement.model.Location;
import erp.max.inventoryManagement.model.ProductMovement;
import erp.max.inventoryManagement.repository.LocationRepository;
import erp.max.inventoryManagement.repository.ProductMovementRepository;
import erp.max.inventoryManagement.service.LocationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {
    private final LocationRepository locRepo;
    private final ProductMovementRepository moveRepo;
    public LocationServiceImp(LocationRepository locRepo, ProductMovementRepository moveRepo) {
        this.locRepo = locRepo;
        this.moveRepo = moveRepo;
    }


    @Override
    public LocationDTO getLocationById(String id) {
        return LocationMapper.mapToDTO(locRepo.findById(id).orElse(null));

    }

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        Optional<Location> existingLocation = locRepo.findByLocationCode(locationDTO.getLocationCode());
        if(existingLocation.isPresent()){
            return null;
        }
        Location loc = locRepo.save(LocationMapper.mapToEntity(locationDTO));
        return LocationMapper.mapToDTO(loc);
    }

    @Override
    public LocationResponse getAllLocations(int page) {
        Long numOfPages = locRepo.count();
        numOfPages = numOfPages/6;
        return new LocationResponse(locRepo.findAll(PageRequest.of(page,6)).stream()
                .map(LocationMapper::mapToDTO).toList(),page,numOfPages.intValue());
    }

    @Override
    public LocationResponse getAllLocations() {
        return new LocationResponse(locRepo.findAll().stream()
                .map(LocationMapper::mapToDTO).toList(),0,0);
    }

    @Override
    public LocationResponse getAllLocationsExcept(String LocationCode) {
        List<Location> locs = locRepo.findAll();
        locs.removeIf(location -> location.getLocationCode().equals(LocationCode));
        return new LocationResponse(locs.stream()
                .map(LocationMapper::mapToDTO).toList(),0,0);
    }

    @Override
    public boolean updateLocation(LocationDTO locationDTO) {
        Optional<Location> loc = locRepo.findById(locationDTO.getId());
        if(loc.isEmpty() || !loc.get().getLocationCode().equals(locationDTO.getLocationCode()))
            return false;

        Location location = loc.get();
        Optional<List<ProductMovement>> fromLocs = moveRepo.findByFromLocation(loc.get().getLocationName());
        Optional<List<ProductMovement>> toLocs = moveRepo.findByToLocation(loc.get().getLocationName());
        for(int i=0;i<fromLocs.get().size();i++){
            fromLocs.get().get(i).setFromLocation(locationDTO.getLocationName());
            moveRepo.save(fromLocs.get().get(i));
        }

        for(int i=0;i<toLocs.get().size();i++){
            toLocs.get().get(i).setToLocation(locationDTO.getLocationName());
            moveRepo.save(toLocs.get().get(i));
        }

        location.setLocationCode(locationDTO.getLocationCode());
        location.setLocationName(locationDTO.getLocationName());
        locRepo.save(location);

        return true;
    }

    @Override
    public boolean deleteLocation(String id) {
        Optional<Location> loc = locRepo.findById(id);
        if(loc.isEmpty())
            return false;
        locRepo.delete(loc.get());
        return true;
    }
}
