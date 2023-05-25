package org.n2w;

import java.util.HashMap;
import java.util.Map;

public enum DICTIONARY {
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
