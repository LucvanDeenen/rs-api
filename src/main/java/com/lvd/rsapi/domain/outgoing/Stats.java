package com.lvd.rsapi.domain.outgoing;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Stats implementation of Rank.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("java:S1700")
public final class Stats extends Rank {

  private int level;
  private int experience;
}
