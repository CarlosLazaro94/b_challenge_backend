package pe.bancom.support.configuration;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableConfigurationProperties({MicroserviceConfiguration.class, DataBaseProperties.class})
public class BancomConfiguration {
  @Bean
  public DataSource dataSource(DataBaseProperties configuration) {
    DriverManagerDataSource source = new DriverManagerDataSource();
    source.setDriverClassName(configuration.getDriverClassName());
    source.setUrl(configuration.getUrl());
    source.setUsername(configuration.getUsername());
    source.setPassword(configuration.getPassword());
    return source;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource source) {
    return new JdbcTemplate(source);
  }
}
