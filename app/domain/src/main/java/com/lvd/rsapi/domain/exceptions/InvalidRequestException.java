package com.lvd.rsapi.domain.exceptions;

/**
 * In the case of a bad request this exception is thrown.
 */
public class InvalidRequestException extends RuntimeException {

  /**
   * Invalid Request Constructor.
   *
   * @param message the context of why it is thrown.
   */
  public InvalidRequestException(String message) {
    super(message);
  }
}
