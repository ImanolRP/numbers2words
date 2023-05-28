package org.n2w;

import java.util.Objects;

public class N2W {

  private static final long MIN_NUMBER = 0L;
  private static final long MAX_NUMBER = 999999999L;

  private N2W() {}

  public static String toWords(Long number) {

    if (Objects.isNull(number)) {
      throw new NullPointerException();
    }

    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException();
    }

    return Millions.get(number);
  }

}
