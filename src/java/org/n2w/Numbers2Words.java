package org.n2w;

import java.util.Objects;

public class Numbers2Words {

  public static String toWords(Long number) {

    final long MINIMAL_NUMBER = 0L;
    final String SPACE = " ";
    final String SEPARATOR = " y ";

    final Long L0 = 0L;
    final Long L1 = 1L;
    final Long L2 = 2L;
    final Long L3 = 3L;

    final int ONES = 0;
    final int TENS = 1;

    if (Objects.isNull(number)) {
      throw new NullPointerException();
    }

    if (MINIMAL_NUMBER > number) {
      throw new IllegalArgumentException();
    }

    Long[] tokens = tokenize(number, 1);
    String words = "";

    if (L1.equals(tokens[TENS])) {
      return DICTIONARY.getTeens(tokens[ONES]);
    }
    if (L2.equals(tokens[TENS])) {
      if (L0.equals(tokens[ONES])) {
        return DICTIONARY.getTwenties(tokens[ONES]);
      }
      if (L2.equals(tokens[ONES])) {
        return DICTIONARY.getTwenties(tokens[ONES]);
      }
      if (L3.equals(tokens[ONES])) {
        return DICTIONARY.getTwenties(tokens[ONES]);
      }
      return DICTIONARY.getTwenties(-1L)
          .concat(DICTIONARY.getOnes(tokens[ONES]));
    }
    if (Objects.isNull(tokens[TENS])) {
      if (L0.equals(number)) {
        return DICTIONARY.getOnes(L0);
      }
      return DICTIONARY.getOnes(tokens[ONES]);
    }
    return null;
  }

  private Numbers2Words() {}

  private static Long[] tokenize(Long number, int tokenLength) {
    int index = 0;
    Long[] tokens = new Long[3];
    int base = (int) Math.pow(10, tokenLength);
    while (number > 0) {
      tokens[index] = (number % base);
      number = (number / base);
      index++;
    }
    return tokens;
  }

}
