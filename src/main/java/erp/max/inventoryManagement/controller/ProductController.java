package erp.max.inventoryManagement.controller;

import erp.max.inventoryManagement.JsonResponse.ProductResponse;
import erp.max.inventoryManagement.dto.ProductDTO;
import erp.max.inventoryManagement.service.implementation.ProductServiceImp;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductServiceImp prodService;

    public ProductController(ProductServiceImp prodService) {
        this.prodService = prodService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") String id) {
        ProductDTO product = prodService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(product != null ? 200 : 404));
    }

    @GetMapping
    public ResponseEntity<ProductResponse> getAllProducts(@RequestParam(name = "page", defaultValue = "0") int page){
        return new ResponseEntity<>(prodService.getAllProducts(page), HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = prodService.createProduct(productDTO);
        if(savedProduct != null)
            return new ResponseEntity<>(savedProduct, HttpStatusCode.valueOf(201));
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    @PatchMapping()
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO savedProduct = prodService.updateProduct(productDTO);
        if(savedProduct != null)
            return new ResponseEntity<>(savedProduct, HttpStatusCode.valueOf(200));
        return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }
}
