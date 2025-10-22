package com.lvd.rsapi.domain.exceptions;

/**
 * Represents all exceptions being caused by interaction with external systems.
 */
public class ApiException extends RuntimeException {

  /**
   * Exception Constructor.
   *
   * @param message extra details with regard to the API exception occurring.
   */
  public ApiException(String message) {
    super(message);
  }
}
