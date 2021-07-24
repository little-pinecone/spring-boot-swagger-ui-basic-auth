package in.keepgrowing.springbootswaggeruibasicauth.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }
}
