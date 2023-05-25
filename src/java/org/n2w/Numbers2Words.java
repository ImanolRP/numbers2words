package org.n2w;

import java.util.HashMap;
import java.util.Map;
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

  private enum DICTIONARY {
    ONES(new HashMap<Long, String>() {
      private static final long serialVersionUID = 6133546176391439970L;
      {
        put(0L, "cero");
        put(1L, "uno");
        put(2L, "dos");
        put(3L, "tres");
        put(4L, "cuatro");
        put(5L, "cinco");
        put(6L, "seis");
        put(7L, "siete");
        put(8L, "ocho");
        put(9L, "nueve");
      }
    }), TEENS(new HashMap<Long, String>() {
      private static final long serialVersionUID = 7198783434212592957L;
      {
        put(0L, "diez");
        put(1L, "once");
        put(2L, "doce");
        put(3L, "trece");
        put(4L, "catorce");
        put(5L, "quince");
        put(6L, "dieciséis");
        put(7L, "diecisiete");
        put(8L, "dieciocho");
        put(9L, "diecinueve");
      }
    }), TWENTIES(new HashMap<Long, String>() {
      private static final long serialVersionUID = 7198783434212592957L;
      {
        put(-1L, "veinti");
        put(0L, "veinte");
        put(2L, "veintidós");
        put(3L, "veintitrés");
      }
    });

    private final HashMap<Long, String> traductions;

    DICTIONARY(HashMap<Long, String> traductions) {
      this.traductions = traductions;
    }

    public static String getOnes(Long number) {
      return ONES.getTraductions().get(number);
    }

    public static String getTeens(Long number) {
      return TEENS.getTraductions().get(number);
    }

    public static String getTwenties(Long number) {
      return TWENTIES.getTraductions().get(number);
    }

    public Map<Long, String> getTraductions() {
      return traductions;
    }
  }

}
