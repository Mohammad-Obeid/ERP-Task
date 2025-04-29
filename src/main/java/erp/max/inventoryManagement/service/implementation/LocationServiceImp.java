package erp.max.inventoryManagement.service.implementation;

import erp.max.inventoryManagement.dto.LocationDTO;
import erp.max.inventoryManagement.mapper.LocationMapper;
import erp.max.inventoryManagement.model.Location;
import erp.max.inventoryManagement.repository.LocationRepository;
import erp.max.inventoryManagement.service.LocationService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImp implements LocationService {
    private final LocationRepository locRepo;

    public LocationServiceImp(LocationRepository locRepo) {
        this.locRepo = locRepo;
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
    public List<LocationDTO> getAllLocations(int page) {
        return locRepo.findAll(PageRequest.of(page,5)).stream()
                .map(LocationMapper::mapToDTO).toList();
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
