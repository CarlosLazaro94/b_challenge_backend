package pe.bancom.support.configuration;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@ConfigurationProperties("pe.bancom.database")
public class DataBaseProperties {
  @NotNull
  private String url;
  @NotNull
  private String username;
  @NotNull
  private String password;
  @NotNull
  private String driverClassName;
}
