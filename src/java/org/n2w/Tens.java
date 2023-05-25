package org.n2w;

import java.util.HashMap;
import java.util.Objects;

public class Tens {

  private static final String SEPARATOR = " y ";

  private static final HashMap<Long, String> tensDictionary =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 7198783434212592957L;
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

  public static String toWords(Long[] tokens) {
    final Long L0 = 0L;
    final Long L1 = 1L;
    final Long L2 = 2L;
    final Long L3 = 3L;

    final int UNIT_IDX = 0;
    final int TENS_IDX = 1;

    if (Objects.isNull(tokens[TENS_IDX])) {
      return Units.toWords(tokens);
    }
    if (L1.equals(tokens[TENS_IDX])) {
      return teensDictionary.get(tokens[UNIT_IDX]);
    }
    if (L2.equals(tokens[TENS_IDX])) {
      if (L0.equals(tokens[UNIT_IDX])) {
        return twentiesDictionary.get(tokens[UNIT_IDX]);
      }
      if (L2.equals(tokens[UNIT_IDX])) {
        return twentiesDictionary.get(tokens[UNIT_IDX]);
      }
      if (L3.equals(tokens[UNIT_IDX])) {
        return twentiesDictionary.get(tokens[UNIT_IDX]);
      }
      return twentiesDictionary.get(-1L)
          .concat(Units.toWords(tokens));
    }
    if (L0.equals(tokens[UNIT_IDX])) {
      return tensDictionary.get(tokens[TENS_IDX]);
    }
    return tensDictionary.get(tokens[TENS_IDX]).concat(SEPARATOR)
        .concat(Units.toWords(tokens));
  }
}
