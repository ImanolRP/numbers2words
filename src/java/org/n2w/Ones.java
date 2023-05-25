package org.n2w;

import java.util.Objects;

public class Ones {

  public static String toWords(Long[] token) {
    final Long L0 = 0L;
    final int ONES = 0;

    if (Objects.isNull(token[0])) {
      return DICTIONARY.getOnes(L0);
    }
    return DICTIONARY.getOnes(token[ONES]);
  }

}
