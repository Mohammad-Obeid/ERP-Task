package erp.max.inventoryManagement.controller;

import erp.max.inventoryManagement.JsonResponse.LocationResponse;
import erp.max.inventoryManagement.dto.LocationDTO;
import erp.max.inventoryManagement.service.implementation.LocationServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {
    private final LocationServiceImp locService;

    public LocationController(LocationServiceImp locService) {
        this.locService = locService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable("id") String id){
        LocationDTO loc = locService.getLocationById(id);
        if(loc==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(loc,HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<LocationResponse> getLocations(@RequestParam (name = "page", defaultValue = "0") int pageNum){
        LocationResponse locs = locService.getAllLocations(pageNum);
        if(locs.getLocations().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(locService.getAllLocations(pageNum), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<LocationResponse> getAllLocations(){
        LocationResponse locs = locService.getAllLocations();
        if(locs.getLocations().isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(locService.getAllLocations(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LocationDTO> CreateLocation(@RequestBody LocationDTO location){
        LocationDTO loc = locService.createLocation(location);
        if(loc==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(loc,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteLocation(@PathVariable("id") String id){
        boolean deleted = locService.deleteLocation(id);
        if(!deleted)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(deleted,HttpStatus.OK);
    }
    @PatchMapping()
    public ResponseEntity<Boolean> updateLocation(@RequestBody LocationDTO location){
        boolean updated = locService.updateLocation(location);
        if(!updated)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }
}
