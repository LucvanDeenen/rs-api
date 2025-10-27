package com.lvd.rsapi.api;


import com.lvd.rsapi.generated.model.Player;

/**
 * Player business logic.
 */
public interface PlayerService {

  /**
   * Fetches the user from the endpoint based on the name.
   *
   * @param username   the ingame name of the user.
   * @param accountType the type of account to search for.
   * @return the details of the users account from the accountType.
   */
  Player getPlayer(String username, String accountType);

}
