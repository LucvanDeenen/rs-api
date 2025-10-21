package com.lvd.rsapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvd.rsapi.domain.outgoing.Player;
import org.springframework.stereotype.Component;

/**
 * Util class to help format data.
 */
@Component
public class Formatter {

  private final ObjectMapper objectMapper;

  public Formatter(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  /**
   * Maps the string of data onto the Player POJO.
   *
   * @param data a JSON string.
   * @return an instance of the Player Object.
   */
  public Player formatString(String data) throws JsonProcessingException {
    if (data == null || data.isEmpty()) {
      return null;
    }

    if (data.trim().startsWith("\"") && data.trim().endsWith("\"")) {
      data = objectMapper.readValue(data, String.class);
    }

    return objectMapper.readValue(data, Player.class);
  }
}
