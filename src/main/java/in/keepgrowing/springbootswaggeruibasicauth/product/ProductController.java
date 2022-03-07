package in.keepgrowing.springbootswaggeruibasicauth.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    @Operation(summary = "Find all products")
    public ResponseEntity<List<ProductDto>> findAll() {
        var products = productRepository.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @DeleteMapping
    @Operation(summary = "Endpoint for testing CSRF configuration, doesn't remove anything")
    public ResponseEntity<Void> delete() {
        return ResponseEntity.noContent().build();
    }
}
