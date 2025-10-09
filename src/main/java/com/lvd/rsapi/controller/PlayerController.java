package com.lvd.rsapi.controller;

import com.lvd.rsapi.constants.Constants;
import com.lvd.rsapi.domain.Player;
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
   * @param name input for searching the user.
   * @return Instantiated and formatted found player.
   */
  @GetMapping
  public ResponseEntity<Player> getPlayer(@RequestParam String name) {
    try {
      final var result = restTemplate.getForObject(name, String.class);
      if (result == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      final var player = playerService.formatResult(result);
      return new ResponseEntity<>(player, HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
