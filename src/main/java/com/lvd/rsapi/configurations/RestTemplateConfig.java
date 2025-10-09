package com.lvd.rsapi.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

/**
 * Configures the Rest template.
 */
@Configuration
public class RestTemplateConfig {

  @Value("${jagex.endpoints.playerHighscore}")
  private String baseUrl;

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
