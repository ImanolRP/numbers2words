package org.n2w;

import java.util.Objects;

public class Units {

  public static String toWords(Long[] token) {
    final Long L0 = 0L;
    final int UNIT_IDX = 0;

    if (Objects.isNull(token[0])) {
      return DICTIONARY.getUnits(L0);
    }
    return DICTIONARY.getUnits(token[UNIT_IDX]);
  }

}
