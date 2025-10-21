package com.lvd.rsapi.domain.incoming;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 * Player POJO.
 */
@Data
public class User {

  private String name;

  @JsonProperty("skills")
  private List<Stats> stats;

  @JsonProperty("activities")
  private List<Scores> scores;

}
