package com.lvd.rsapi.application.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Global CORS configuration to expose the public API safely.
 */
@Configuration
public class CorsConfig {

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // apply to all endpoints
            .allowedOrigins(
                "https://editor.swagger.io",     // public Swagger editor
                "https://petstore.swagger.io",   // alternate OpenAPI UI
                "https://rs-api.dedeen.dev",     // your API domain itself
                "*"                              // allow other public clients (optional, see below)
            )
            .allowedMethods("GET", "POST", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(false)
            .maxAge(3600);
      }
    };
  }
}
