package com.lvd.rsapi.connectors;

import static com.lvd.rsapi.constants.ApiConstants.PLAYER_QUERY;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lvd.rsapi.api.RunescapeConnector;
import com.lvd.rsapi.domain.enums.AccountType;
import com.lvd.rsapi.domain.exceptions.ApiException;
import com.lvd.rsapi.domain.osrs.User;
import com.lvd.rsapi.util.Formatter;
import org.springframework.stereotype.Service;
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
    try {
      final String resource = type.getEndpoint() + PLAYER_QUERY + username;
      String result = restTemplate.getForObject(resource, String.class);
      return formatter.formatString(result);
    } catch (JsonProcessingException e) {
      throw new ApiException("An issue occurred with the formatting of the response.");
    }
  }
}
