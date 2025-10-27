package com.lvd.rsapi.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Endpoints exposed by jagex.
 */
@Getter
@AllArgsConstructor
public enum AccountType {
  NORMAL("Normal", "/m=hiscore_oldschool/index_lite.json"), IRONMAN("Ironman",
      "/m=hiscore_oldschool_ironman/index_lite.json"), HARDCORE_IRONMAN("Hardcore Ironman",
      "/m=hiscore_oldschool_hardcore_ironman/index_lite.json"), ULTIMATE_IRONMAN("Ultimate Ironman",
      "/m=hiscore_oldschool_ultimate/index_lite.json"), DEADMAN("Deadman",
      "/m=hiscore_oldschool_deadman/index_lite.json"), SEASONAL("Leagues",
      "/m=hiscore_oldschool_seasonal/index_lite.json"), TOURNAMENT("Grid Master",
      "/m=hiscore_oldschool_tournament/index_lite.json"), FRESH_START_WORLD("Fresh Start",
      "/m=hiscore_oldschool_fresh_start/index_lite.json"), PURE("1 Defence Pure",
      "/m=hiscore_oldschool_skiller_defence/index_lite.json"), LEVEL_3_SKILLER("Level 3 Skiller",
      "/m=hiscore_oldschool_skiller/index_lite.json");

  private final String name;
  private final String endpoint;
}