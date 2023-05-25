package org.n2w;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Objects;

public class Tens {

  public static String toWords(Long[] tokens) {
    final Long L0 = 0L;
    final Long L1 = 1L;
    final Long L2 = 2L;
    final Long L3 = 3L;

    final int UNIT_IDX = 0;
    final int TENS_IDX = 1;

    if (L1.equals(tokens[TENS_IDX])) {
      return DICTIONARY.getTeens(tokens[UNIT_IDX]);
    }
    if (L2.equals(tokens[TENS_IDX])) {
      if (L0.equals(tokens[UNIT_IDX])) {
        return DICTIONARY.getTwenties(tokens[UNIT_IDX]);
      }
      if (L2.equals(tokens[UNIT_IDX])) {
        return DICTIONARY.getTwenties(tokens[UNIT_IDX]);
      }
      if (L3.equals(tokens[UNIT_IDX])) {
        return DICTIONARY.getTwenties(tokens[UNIT_IDX]);
      }
      return DICTIONARY.getTwenties(-1L)
          .concat(Units.toWords(ArrayUtils.subarray(tokens, 0, 1)));
    }
    if (Objects.isNull(tokens[TENS_IDX])) {
      return Units.toWords(ArrayUtils.subarray(tokens, 0, 1));
    }
    return null;
  }
}
