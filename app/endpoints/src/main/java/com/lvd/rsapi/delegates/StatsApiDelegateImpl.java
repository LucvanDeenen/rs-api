package com.lvd.rsapi.delegates;

import com.lvd.rsapi.generated.api.StatsApiDelegate;
import com.lvd.rsapi.generated.model.Player;
import com.lvd.rsapi.service.PlayerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller exposing player details.
 */
@Service
public class StatsApiDelegateImpl implements StatsApiDelegate {

  private final PlayerServiceImpl playerService;

  /**
   * Constructor for the Player controller.
   *
   * @param playerService service layer connector.
   */
  public StatsApiDelegateImpl(PlayerServiceImpl playerService) {
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
  public ResponseEntity<Player> getPlayer(@RequestParam String name,
      @RequestParam String highscore) {
    try {
//      final Player player = playerService.getUser(name, highscore);
      return new ResponseEntity<>(new Player(), HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
