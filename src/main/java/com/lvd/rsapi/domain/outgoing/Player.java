package com.lvd.rsapi.domain.outgoing;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Data;

/**
 * Player POJO.
 */
@Data
public class Player {

  private String name;

  @JsonProperty("activities")
  private Map<String, Object> scores;

  @JsonProperty("skills")
  private Map<String, Object> stats;
}
