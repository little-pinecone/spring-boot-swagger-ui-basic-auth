package in.keepgrowing.springbootswaggeruibasicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringBootSwaggerUiBasicAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwaggerUiBasicAuthApplication.class, args);
	}

}
