package org.n2w;

import java.util.HashMap;

public class Numbers2Words {

  private static final HashMap<Long, String> DICTIONARY =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 1664036289301366765L;
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

  private Numbers2Words() {}

  public static String toWords(Long number) {
    return DICTIONARY.get(number);
  }

}
