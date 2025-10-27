package com.lvd.rsapi.handlers;

import static com.lvd.rsapi.constants.ApiConstants.ERROR;
import static com.lvd.rsapi.constants.ApiConstants.MSG;
import static com.lvd.rsapi.constants.ApiConstants.PATH;
import static com.lvd.rsapi.constants.ApiConstants.STATUS;
import static com.lvd.rsapi.constants.ApiConstants.TIMESTAMP;

import com.lvd.rsapi.domain.exceptions.ApiException;
import com.lvd.rsapi.domain.exceptions.InvalidRequestException;
import com.lvd.rsapi.domain.exceptions.UserNotFoundException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Handles all exceptions thrown on application level.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handles {@link InvalidRequestException} thrown when a client submits an invalid request, such
   * as a malformed parameter or unsupported enum value.
   *
   * @param ex      the thrown {@code InvalidRequestException}
   * @param request the current {@link WebRequest} providing request context
   * @return a {@link ResponseEntity} with HTTP 400 (Bad Request) and an error body containing
   * details.
   */
  @ExceptionHandler(InvalidRequestException.class)
  public ResponseEntity<Object> handleInvalidRequest(InvalidRequestException ex) {
    return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
  }

  /**
   * Handles {@link UserNotFoundException} thrown when a requested player or resource could not be
   * found in the data source.
   *
   * @param ex      the thrown {@code UserNotFoundException}
   * @param request the current {@link WebRequest} providing request context
   * @return a {@link ResponseEntity} with HTTP 404 (Not Found) and an error body describing the
   * issue.
   */
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex) {
    return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
  }

  /**
   * Handles {@link ApiException} instances thrown during external API interactions or service-level
   * communication errors. Uses the HTTP status provided by the exception to determine the response
   * status code.
   *
   * @param ex      the thrown {@code ApiException} containing a message and optional HTTP status
   * @param request the current {@link WebRequest} providing request context
   * @return a {@link ResponseEntity} with the status code and message defined in
   * {@link ApiException}, formatted into a consistent error response body
   */
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<Object> handleApiException(ApiException ex) {
    return buildResponse(ex.getStatusCode(), ex.getMessage());
  }

  private ResponseEntity<Object> buildResponse(HttpStatus status, String message) {
    Map<String, Object> body = new HashMap<>();
    body.put(TIMESTAMP, Instant.now().toString());
    body.put(STATUS, status.value());
    body.put(ERROR, status.getReasonPhrase());
    body.put(MSG, message);
    return new ResponseEntity<>(body, status);
  }
}
