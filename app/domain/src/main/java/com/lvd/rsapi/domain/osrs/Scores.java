package com.lvd.rsapi.domain.osrs;

import lombok.Data;

/**
 * The ingame boss/minigame activity.
 */
@Data
public class Scores {

  private int id;
  private String name;
  private long rank;
  private long score;
}