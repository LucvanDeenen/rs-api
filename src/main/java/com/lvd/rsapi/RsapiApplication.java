package com.lvd.rsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Runescape API wrapper.
 */
@SpringBootApplication
public class RsapiApplication {

  /**
   * Application Entry.
   *
   * @param args arguments for the application.
   */
  public static void main(String[] args) {
    SpringApplication.run(RsapiApplication.class, args);
  }
}
