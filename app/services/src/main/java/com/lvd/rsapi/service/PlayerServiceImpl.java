package com.lvd.rsapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lvd.rsapi.api.PlayerService;
import com.lvd.rsapi.generated.model.Player;
import com.lvd.rsapi.util.Formatter;
import org.springframework.stereotype.Service;

/**
 * A service responsible for formatting all player related data.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

  private final Formatter formatter;

  /**
   * Player Service constructor, that uses injector based .
   *
   * @param formatter autowired bean.
   */
  public PlayerServiceImpl(Formatter formatter) {
    this.formatter = formatter;
  }

  @Override
  public Player getUser(String username, String highscores) {
//    if (username == null || username.isBlank()) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    final Highscores type;
//    try {
//      if (highscore == null || highscore.isBlank()) {
//
//      }
//      type = Highscores.valueOf(highscore.trim().toUpperCase());
//    } catch (IllegalArgumentException e) {
//      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    final String resource = type.getEndpoint() + Constants.PLAYER_QUERY + username;
//    try {
//      var result = restTemplate.getForObject(resource, String.class);
//      if (result == null) {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//      }

    try {
      // VALIDATE

      // GET DATA

      // FORMAT DATA
//      final Player player = formatter.formatString("");

      // ENHANCE

      // RETURN
      return new Player();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
