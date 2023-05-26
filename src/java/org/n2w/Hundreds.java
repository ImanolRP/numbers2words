package org.n2w;

import java.util.HashMap;

public class Hundreds {

  private static final int UNIT_IDX = 0;
  private static final int TENS_IDX = 1;
  private static final int HUNDREDS_IDX = 2;

  private static final String SPACE = " ";

  private static final HashMap<Long, String> dictionary =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 6750413632014975465L;
        {
          put(1L, "ciento");
          put(2L, "doscientos");
          put(3L, "trescientos");
          put(4L, "cuatrocientos");
          put(5L, "quinientos");
          put(6L, "seiscientos");
          put(7L, "setecientos");
          put(8L, "ochocientos");
          put(9L, "novecientos");
        }
      };

  public static String toWords(long[] tokens) {


    final String L100 = "cien";

    if (0L == tokens[HUNDREDS_IDX]) {
      return Tens.toWords(tokens);
    }
    if (1L == tokens[HUNDREDS_IDX] //
        && 0L == tokens[TENS_IDX] //
        && 0L == tokens[UNIT_IDX]) {
      return L100;
    }
    return dictionary.get(tokens[HUNDREDS_IDX]).concat(SPACE)
        .concat(Tens.toWords(tokens));
  }

}
