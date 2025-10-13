package com.lvd.rsapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lvd.rsapi.domain.outgoing.Player;
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
   * @param res formats a json value.
   * @return instantiated player object.
   */
  public Player formatResult(String res) {
    if (res == null) {
      return null;
    }

    // ADD SOME VALIDATIONS HERE.

    return objectMapper.convertValue(res, Player.class);
  }
}
