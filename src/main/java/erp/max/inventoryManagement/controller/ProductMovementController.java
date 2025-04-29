package erp.max.inventoryManagement.controller;

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
    public ResponseEntity<List<ProductMovementDTO>> getMovements(@RequestParam(name = "page",defaultValue = "0") int pageNum){
        List<ProductMovementDTO> moves = prodService.getAllProductMovements(pageNum);
        if(moves.isEmpty()){
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
    @PatchMapping()
    public ResponseEntity<ProductMovementDTO> updateMove(@RequestBody ProductMovementDTO move){
        ProductMovementDTO updatedMove = prodService.updateProductMovement(move);
        if(updatedMove == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedMove, HttpStatus.OK);
    }
}
