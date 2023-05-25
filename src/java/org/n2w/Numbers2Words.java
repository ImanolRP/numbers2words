package org.n2w;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Numbers2Words {

  public static String toWords(Long number) {
    if (Objects.isNull(number)) {
      throw new NullPointerException();
    }

    if (number >= 10L) {
      return DICTIONARY.getTeens(number);
    }
    return DICTIONARY.getOnes(number);
  }

  private Numbers2Words() {}

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
        put(10L, "diez");
        put(11L, "once");
        put(12L, "doce");
        put(13L, "trece");
        put(14L, "catorce");
        put(15L, "quince");
        put(16L, "dieciséis");
        put(17L, "diecisiete");
        put(18L, "dieciocho");
        put(19L, "diecinueve");
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

    public Map<Long, String> getTraductions() {
      return traductions;
    }
  }

}
