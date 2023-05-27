package org.n2w;

import java.util.HashMap;

public class Units {

  private static final String L0 = "cero";

  private static final HashMap<Long, String> dictionary =
      new HashMap<Long, String>() {
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
      };

  private Units() {}

  public static String get(Long token) {
    if (0L == token) {
      return L0;
    }
    return dictionary.get(token);
  }

}
