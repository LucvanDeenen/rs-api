package com.lvd.rsapi.domain.outgoing;

import java.util.Map;
import lombok.Data;

/**
 * Simplified player response.
 */
@Data
public class Player {

  private Map<String, String> metadata;
  private Map<String, String> stats;

}
