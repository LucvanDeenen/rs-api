package com.lvd.rsapi.application;

import static com.lvd.rsapi.application.constants.Constants.PROPERTIES;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * Runescape API wrapper.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.lvd.rsapi"})
public class RsapiApplication {

  /**
   * Application Entry.
   *
   * @param args arguments for the application.
   */
  public static void main(String[] args) {
    final SpringApplication app = new SpringApplicationBuilder(RsapiApplication.class)
        .properties(PROPERTIES)
        .build();
    app.run(args);
  }
}
