package org.n2w;

import java.util.Objects;

public class Numbers2Words {

  private static final long MINIMAL_NUMBER = 0L;

  public static String toWords(Long number) {

    if (Objects.isNull(number)) {
      throw new NullPointerException();
    }

    if (MINIMAL_NUMBER > number) {
      throw new IllegalArgumentException();
    }

    long[] tokens = tokenize(number, 1);

    return Hundreds.toWords(tokens);
  }

  private Numbers2Words() {}

  private static long[] tokenize(Long number, int tokenLength) {
    int index = 0;
    long[] tokens = new long[3];
    int base = (int) Math.pow(10, tokenLength);
    while (number > 0) {
      tokens[index] = (number % base);
      number = (number / base);
      index++;
    }
    return tokens;
  }

}
