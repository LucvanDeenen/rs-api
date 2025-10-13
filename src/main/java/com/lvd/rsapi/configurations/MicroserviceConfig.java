package com.lvd.rsapi.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Configures the Rest template.
 */
@Configuration
public class MicroserviceConfig {

  @Value("${jagex.baseUrl}")
  private String baseUrl;

  /**
   * Capabilities to convert JSON data into objects.
   *
   * @return Instantiates a configured object mapper.
   */
  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  /**
   * Rest template bean.
   *
   * @return usable rest template configured with the URI.
   */
  @Bean
  public RestTemplate restTemplate() {
    final RestTemplate restTemplate = new RestTemplate();
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
    return restTemplate;
  }
}
