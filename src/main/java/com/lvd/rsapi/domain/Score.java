package com.lvd.rsapi.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Score implementation of Rank.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("java:S1700")
public final class Score extends Rank {

  private int score;
}
