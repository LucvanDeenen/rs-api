package com.lvd.rsapi.service;

import static com.lvd.rsapi.constants.CommonConstants.ACCOUNT_TYPE;
import static com.lvd.rsapi.constants.CommonConstants.NAME;

import com.lvd.rsapi.api.PlayerService;
import com.lvd.rsapi.api.RunescapeConnector;
import com.lvd.rsapi.domain.enums.AccountType;
import com.lvd.rsapi.domain.osrs.User;
import com.lvd.rsapi.generated.model.Player;
import com.lvd.rsapi.mappers.PlayerMapper;
import com.lvd.rsapi.util.Validator;
import org.springframework.stereotype.Service;

/**
 * A service responsible for formatting all player related data.
 */
@Service
public class PlayerServiceImpl implements PlayerService {

  private final RunescapeConnector connector;
  private final PlayerMapper mapper;

  /**
   * Player service constructor.
   *
   * @param connector helps with interaction of the runescape API.
   */
  public PlayerServiceImpl(RunescapeConnector connector, PlayerMapper mapper) {
    this.connector = connector;
    this.mapper = mapper;
  }

  @Override
  public Player getPlayer(String username, String type) {
    Validator.checkEmpty(username, NAME);
    AccountType accountType = Validator.parseEnum(
        type,
        ACCOUNT_TYPE,
        AccountType.class,
        AccountType.NORMAL
    );

    User user = connector.getUser(username, accountType);
    return mapper.toPlayer(user);
  }
}
