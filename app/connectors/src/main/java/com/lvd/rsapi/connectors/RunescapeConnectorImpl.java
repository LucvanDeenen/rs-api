package com.lvd.rsapi.connectors;


import static com.lvd.rsapi.constants.ApiConstants.PLAYER_QUERY;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lvd.rsapi.api.RunescapeConnector;
import com.lvd.rsapi.domain.enums.AccountType;
import com.lvd.rsapi.domain.exceptions.ApiException;
import com.lvd.rsapi.domain.exceptions.UserNotFoundException;
import com.lvd.rsapi.domain.osrs.User;
import com.lvd.rsapi.util.Formatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Implementation of the RunescapeConnector interface.
 */
@Service
public class RunescapeConnectorImpl implements RunescapeConnector {

  private final RestTemplate restTemplate;
  private final Formatter formatter;

  /**
   * Runescape Connector constructor.
   *
   * @param formatter helps convert the responses from the API's.
   */
  public RunescapeConnectorImpl(Formatter formatter, RestTemplate restTemplate) {
    this.formatter = formatter;
    this.restTemplate = restTemplate;
  }

  @Override
  public User getUser(String username, AccountType type) {
    final ResponseEntity<String> response;
    try {
      String resource = type.getEndpoint() + PLAYER_QUERY + username;
      response = restTemplate.getForEntity(resource, String.class);
    } catch (HttpClientErrorException e) {
      if (HttpStatus.NOT_FOUND.equals(e.getStatusCode())) {
        throw new UserNotFoundException(String.format("User %s not found", username));
      }
      throw new ApiException(e.getResponseBodyAsString(),
          HttpStatus.valueOf(e.getStatusCode().value()));
    }

    final User user;
    try {
      user = formatter.formatString(String.valueOf(response.getBody()));
    } catch (JsonProcessingException e) {
      throw new ApiException("An issue occurred with the formatting of the response.",
          HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return user;
  }
}
