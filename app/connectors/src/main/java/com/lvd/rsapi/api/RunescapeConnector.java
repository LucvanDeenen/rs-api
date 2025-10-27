package com.lvd.rsapi.api;

import com.lvd.rsapi.domain.enums.AccountType;
import com.lvd.rsapi.domain.osrs.User;

/**
 * Handles all calls towards the Runescape API.
 */
public interface RunescapeConnector {

  /**
   * Fetches the user from the Runescape / Jagex API.
   *
   * @param username     the players in-game name.
   * @param accountType the type of account.
   * @return the details of the users account.
   */
  User getUser(String username, AccountType accountType);

}
