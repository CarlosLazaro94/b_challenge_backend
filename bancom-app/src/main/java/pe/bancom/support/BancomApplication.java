package pe.bancom.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "pe.bancom")
public class BancomApplication {
  public static void main(String[] args) {
    SpringApplication.run(BancomApplication.class, args);
  }
}