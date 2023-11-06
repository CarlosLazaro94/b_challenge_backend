package pe.bancom.support.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
      return new OpenAPI()
          .info(new Info().title("Bancom Apis")
              .contact(new Contact().name("Carlos Lazaro").email("carlos.lazaro.sotelo@gmail.com"))
              .description("This apis for challenge")
              .version("1.0"));
    }
}
