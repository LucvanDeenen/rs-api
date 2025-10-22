package com.lvd.rsapi.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

/**
 * Represents all exceptions being caused by interaction with external systems.
 */
public class ApiException extends RuntimeException {

  @Getter
  public HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

  /**
   * Exception Constructor.
   *
   * @param message extra details with regard to the API exception occurring.
   */
  public ApiException(String message) {
    super(message);
  }

  /**
   * Exception Constructor.
   *
   * @param message extra details with regard to the API exception occurring.
   */
  public ApiException(String message, HttpStatus statusCode) {
    super(message);
    this.statusCode = statusCode;
  }
}
