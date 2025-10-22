package com.lvd.rsapi.mappers;

import com.lvd.rsapi.domain.osrs.User;
import com.lvd.rsapi.generated.model.Player;
import java.util.HashMap;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Helps convert the values to the Player POJO.
 */
@Mapper(componentModel = "spring")
public interface PlayerMapper {

  /**
   * Maps the user object onto the player.
   *
   * @param user the data from the Runescape API.
   * @return an instantiated player object.
   */
  @Mapping(target = "metadata", expression = "java(mapMetadata(user))")
  @Mapping(target = "stats", expression = "java(mapStats(user))")
  Player toPlayer(User user);

  /**
   * Helps map the meta-data onto the player object.
   *
   * @param user the user instance.
   * @return a map with the converted values.
   */
  default Map<String, String> mapMetadata(User user) {
    Map<String, String> metadata = new HashMap<>();
    if (user.getScores() != null) {
      user.getScores().forEach(score -> {
        String value = score.getScore() < 0 ? "Unranked" : String.valueOf(score.getScore());
        metadata.put(score.getName(), value);
      });
    }

    return metadata;
  }

  /**
   * Helps map the stats onto the player object.
   *
   * @param user the user instance.
   * @return a map with the converted values.
   */
  default Map<String, String> mapStats(User user) {
    Map<String, String> statsMap = new HashMap<>();
    if (user.getStats() != null) {
      user.getStats().forEach(stat -> {
        statsMap.put(stat.getName(),
            String.valueOf(stat.getLevel()));
      });
    }
    return statsMap;
  }
}
