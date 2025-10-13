package com.lvd.rsapi.controller;

import static com.lvd.rsapi.constants.Constants.PLAYER_QUERY;

import com.lvd.rsapi.constants.Constants;
import com.lvd.rsapi.domain.enums.Highscores;
import com.lvd.rsapi.domain.dto.User;
import com.lvd.rsapi.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controller exposing player details.
 */
@RestController
@RequestMapping(Constants.STATS_ENDPOINT)
public class PlayerController {

  private final PlayerService playerService;
  private final RestTemplate restTemplate;

  /**
   * Constructor for the Player controller.
   *
   * @param playerService service layer connector.
   * @param restTemplate  rest template setup provided by bean.
   */
  @Autowired
  public PlayerController(PlayerService playerService, RestTemplate restTemplate) {
    this.playerService = playerService;
    this.restTemplate = restTemplate;
  }

  /**
   * Endpoint for fetching a player by name.
   *
   * @param name      input for searching the user.
   * @param highscore the type of account.
   * @return Instantiated and formatted found player.
   */
  @GetMapping
  public ResponseEntity<User> getPlayer(@RequestParam String name, @RequestParam String highscore) {
    if (name == null || name.isBlank() || highscore == null || highscore.isBlank()) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    final Highscores type;
    try {
      type = Highscores.valueOf(highscore.trim().toUpperCase());
    } catch (IllegalArgumentException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    final String resource = type.getEndpoint() + PLAYER_QUERY + name;
    try {
      var result = restTemplate.getForObject(resource, String.class);
      if (result == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      final User user = playerService.formatResult(result);
      return new ResponseEntity<>(user, HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
