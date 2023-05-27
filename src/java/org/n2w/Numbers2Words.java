package org.n2w;

import java.util.Objects;

public class Numbers2Words {

  private static final long MINIMAL_NUMBER = 0L;

  private Numbers2Words() {}

  public static String toWords(Long number) {

    if (Objects.isNull(number)) {
      throw new NullPointerException();
    }

    if (MINIMAL_NUMBER > number) {
      throw new IllegalArgumentException();
    }

    return Millions.get(number);
  }

}
