package org.n2w;

import java.util.HashMap;

public class Tens {

  private static final int BASE_IDX = 0;
  private static final int TENS_IDX = 1;

  private static final String SEPARATOR = " y ";

  private static final HashMap<Long, String> tensDictionary =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 878914469088093082L;
        {
          put(3L, "treinta");
          put(4L, "cuarenta");
          put(5L, "cincuenta");
          put(6L, "sesenta");
          put(7L, "setenta");
          put(8L, "ochenta");
          put(9L, "noventa");
        }
      };

  private static final HashMap<Long, String> teensDictionary =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 4349990935586367340L;
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
      };

  private static final HashMap<Long, String> twentiesDictionary =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 7198783434212592957L;
        {
          put(-1L, "veinti");
          put(0L, "veinte");
          put(2L, "veintidós");
          put(3L, "veintitrés");
        }
      };

  private Tens() {}

  public static String get(Long number) {
    long[] tokens = Tokenizer.get(number, 1);

    if (0L == tokens[TENS_IDX]) {
      return Units.get(tokens[BASE_IDX]);
    }
    if (1L == tokens[TENS_IDX]) {
      return teensDictionary.get(tokens[BASE_IDX]);
    }
    if (2L == tokens[TENS_IDX]) {
      if (0L == tokens[BASE_IDX] //
          || 2L == tokens[BASE_IDX] //
          || 3L == tokens[BASE_IDX]) {
        return twentiesDictionary.get(tokens[BASE_IDX]);
      }
      return twentiesDictionary.get(-1L)
          .concat(Units.get(tokens[BASE_IDX]));
    }

    String words = tensDictionary.get(tokens[TENS_IDX]);
    if (0L == tokens[BASE_IDX]) {
      return words;
    }
    return words.concat(SEPARATOR)
        .concat(Units.get(tokens[BASE_IDX]));
  }
}
