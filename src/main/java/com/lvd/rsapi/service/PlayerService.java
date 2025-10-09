package com.lvd.rsapi.service;

import com.lvd.rsapi.domain.Player;
import com.lvd.rsapi.domain.Score;
import com.lvd.rsapi.domain.ScoreName;
import com.lvd.rsapi.domain.Stats;
import com.lvd.rsapi.domain.StatsName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * A service responsible for formatting all player related data.
 */
@Service
public class PlayerService {

  /**
   * Helps set the values of the result.
   *
   * @param res formats a json value.
   * @return instantiated player object.
   */
  public Player formatResult(String res) {
    if (res == null) {
      return null;
    }

    final var lines = List.of(res.split("\\r?\\n"));
    final var stats = setStatistics(lines);
    final var score = setScores(lines);

    return new Player(score, stats);
  }

  private Map<String, Stats> setStatistics(List<String> data) {
    final var statistics = data.stream().map(line -> line.split(",")).filter(line -> line.length > 2).toList();

    final Map<String, Stats> statsMap = new HashMap<>();
    for (int index = 0; index < statistics.size(); index++) {
      final var value = statistics.get(index);
      Stats stats = new Stats();

      stats.setRank(Integer.parseInt(value[0]));
      stats.setLevel(Integer.parseInt(value[1]));
      stats.setExperience(Integer.parseInt(value[2]));

      statsMap.put(StatsName.values()[index].toString(), stats);
    }

    return statsMap;
  }

  private Map<String, Score> setScores(List<String> data) {
    final var scores = data.stream().map(line -> line.split(",")).filter(line -> line.length == 2).toList();

    final Map<String, Score> scoresMap = new HashMap<>();
    for (int index = 0; index < scores.size(); index++) {
      final var value = scores.get(index);
      Score score = new Score();

      score.setRank(Integer.parseInt(value[0]));
      score.setScore(Integer.parseInt(value[1]));

      scoresMap.put(ScoreName.values()[index].toString(), score);
    }

    return scoresMap;
  }
}
