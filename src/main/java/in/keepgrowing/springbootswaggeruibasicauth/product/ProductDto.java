package in.keepgrowing.springbootswaggeruibasicauth.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@Schema(name = "Product")
public class ProductDto {

    private UUID id;
    private String name;
    private String color;
    private String ean;
    private String countryOfOrigin;
    private String price;
    private int availableQuantity;
}
