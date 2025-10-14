package com.lvd.rsapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvd.rsapi.incoming.dto.User;
import org.springframework.stereotype.Service;

/**
 * A service responsible for formatting all player related data.
 */
@Service
public class PlayerService {

  private final ObjectMapper objectMapper;

  /**
   * Player Service constructor.
   *
   * @param objectMapper autowired bean.
   */
  public PlayerService(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  /**
   * Helps set the values of the result.
   *
   * @param result formats a json value.
   * @return instantiated player object.
   */
  public User formatResult(String result) throws JsonProcessingException {
    if (result == null || result.isEmpty()) {
      return null;
    }

    if (result.trim().startsWith("\"") && result.trim().endsWith("\"")) {
      result = objectMapper.readValue(result, String.class);
    }

    return objectMapper.readValue(result, User.class);
  }
}
