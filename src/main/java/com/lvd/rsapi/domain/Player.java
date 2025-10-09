package com.lvd.rsapi.domain;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Player POJO.
 */
@Data
@AllArgsConstructor
public class Player {

  private Map<String, Score> scores;
  private Map<String, Stats> stats;
}
