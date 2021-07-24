package in.keepgrowing.springbootswaggeruibasicauth.product;

import dev.codesoapbox.dummy4j.Dummy4j;

import java.util.List;

public class ProductRepository {

    private final Dummy4j dummy;

    public ProductRepository() {
        this.dummy = new Dummy4j();
    }

    public List<ProductDto> findAll() {
        return dummy.listOf(20, this::generateProduct);
    }

    private ProductDto generateProduct() {
        return ProductDto.builder()
                .id(dummy.identifier().uuid())
                .name(dummy.lorem().word() + " " + dummy.lorem().word())
                .color(dummy.color().name())
                .ean(dummy.identifier().ean13())
                .countryOfOrigin(dummy.nation().country())
                .price(dummy.finance().priceBuilder().withCurrency("USD").build())
                .availableQuantity(dummy.number().nextInt(1, 200))
                .build();
    }
}
