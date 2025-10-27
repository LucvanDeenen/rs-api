package com.lvd.rsapi.domain.exceptions;

/**
 * Exception thrown when the user is not found.
 */
public class UserNotFoundException extends RuntimeException {

  /**
   * Exception constructor.
   *
   * @param message details of the error message.
   */
  public UserNotFoundException(String message) {
    super(message);
  }
}
