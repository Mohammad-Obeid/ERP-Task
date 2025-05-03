package erp.max.inventoryManagement.controller;

import erp.max.inventoryManagement.JsonResponse.LocationProductsResponse;
import erp.max.inventoryManagement.JsonResponse.MovesResponse;
import erp.max.inventoryManagement.JsonResponse.ProductBalance;
import erp.max.inventoryManagement.dto.ProductDTO;
import erp.max.inventoryManagement.dto.ProductMovementDTO;
import erp.max.inventoryManagement.service.implementation.ProductMovementServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-movement")
public class ProductMovementController {
    private final ProductMovementServiceImp prodService;
    public ProductMovementController(ProductMovementServiceImp prodService) {
        this.prodService = prodService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductMovementDTO> findById(@PathVariable("id") String id){
        ProductMovementDTO prod = prodService.getProductMovementById(id);
        if(prod == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<MovesResponse> getMovements(@RequestParam(name = "page",defaultValue = "0") int pageNum){
        MovesResponse moves = prodService.getAllProductMovements(pageNum);
        if(moves.getMoves().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(moves, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductMovementDTO> CreateNewMove(@RequestBody ProductMovementDTO move){
        ProductMovementDTO newMove = prodService.createProductMovement(move);
        if(newMove == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newMove, HttpStatus.CREATED);
    }
    // todo: Change the saved data when updating ...
    @PatchMapping()
    public ResponseEntity<ProductMovementDTO> updateMove(@RequestBody ProductMovementDTO move){
        ProductMovementDTO updatedMove = prodService.updateProductMovement(move);
        if(updatedMove == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMove, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<List<ProductBalance>> getProductBalance(@PathVariable("id") String id){
        List<ProductBalance> balance = prodService.getProductBalance(id);
        if(balance.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
    @GetMapping("location/{id}")
    public ResponseEntity<List<LocationProductsResponse>> getLocationProducts(@PathVariable("id") String id){
        List<LocationProductsResponse> balance = prodService.getLocationProducts(id);
        if(balance.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(balance, HttpStatus.OK);
    }
}
