package com.lvd.rsapi.incoming.dto;

import lombok.Data;

/**
 * Data class for the stats of the player.
 */
@Data
public class Stats {

  private int id;
  private String name;
  private long rank;
  private int level;
  private long xp;

}
