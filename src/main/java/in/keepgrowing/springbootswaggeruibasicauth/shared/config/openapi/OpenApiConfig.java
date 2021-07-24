package in.keepgrowing.springbootswaggeruibasicauth.shared.config.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    private static final String SCHEME_NAME = "basicAuth";
    private static final String SCHEME = "basic";

    @Bean
    public OpenAPI customOpenAPI(OpenApiProperties properties) {
        var openApi = new OpenAPI()
                .info(getInfo(properties));

        addSecurity(openApi);

        return openApi;
    }

    private Info getInfo(OpenApiProperties properties) {
        return new Info()
                .title(properties.getProjectTitle())
                .description(properties.getProjectDescription())
                .version(properties.getProjectVersion())
                .license(getLicense());
    }

    private License getLicense() {
        return new License()
                .name("Unlicense")
                .url("https://unlicense.org/");
    }

    private void addSecurity(OpenAPI openApi) {
        var components = createComponents();
        var securityItem = new SecurityRequirement().addList(SCHEME_NAME);

        openApi
                .components(components)
                .addSecurityItem(securityItem);
    }

    private Components createComponents() {
        var components = new Components();
        components.addSecuritySchemes(SCHEME_NAME, createSecurityScheme());

        return components;
    }

    private SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
                .name(SCHEME_NAME)
                .type(SecurityScheme.Type.HTTP)
                .scheme(SCHEME);
    }
}
