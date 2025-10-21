package com.lvd.rsapi.controllers;

import com.lvd.rsapi.constants.Constants;
import com.lvd.rsapi.domain.outgoing.Player;
import com.lvd.rsapi.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller exposing player details.
 */
@RestController
@RequestMapping(Constants.STATS_ENDPOINT)
public class PlayerController {

  private final PlayerServiceImpl playerService;

  /**
   * Constructor for the Player controller.
   *
   * @param playerService service layer connector.
   */
  @Autowired
  public PlayerController(PlayerServiceImpl playerService) {
    this.playerService = playerService;
  }

  /**
   * Endpoint for fetching a player by name.
   *
   * @param name      input for searching the user.
   * @param highscore the type of account.
   * @return Instantiated and formatted found player.
   */
  @GetMapping
  public ResponseEntity<Player> getPlayer(@RequestParam String name, @RequestParam String highscore) {
    try {
      final Player player = playerService.getUser(name, highscore);
      return new ResponseEntity<>(player, HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
