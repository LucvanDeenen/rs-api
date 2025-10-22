package com.lvd.rsapi.delegates;

import com.lvd.rsapi.api.PlayerService;
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

  private final PlayerService playerService;

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
   * @param name        input for searching the user.
   * @param accountType the accountType of account.
   * @return Instantiated and formatted found player.
   */
  @GetMapping
  public ResponseEntity<Player> getPlayer(@RequestParam String name,
      @RequestParam String accountType) {
    try {
      final Player player = playerService.getPlayer(name, accountType);
      return new ResponseEntity<>(player, HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
  }
}
