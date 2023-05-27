package org.n2w;

public class Millions {

  private static final int BASE_IDX = 0;
  private static final int MILLION_IDX = 1;

  private static final String MILLION = "un millón";
  private static final String MILLIONS = "millones";

  private static final String SPACE = " ";

  public static String get(Long number) {
    long[] tokens = Tokenizer.get(number, 6);

    if (0L == tokens[MILLION_IDX]) {
      return Thousands.get(tokens[BASE_IDX]);
    }
    if (1L == tokens[MILLION_IDX]) {
      if (0L == tokens[BASE_IDX]) {
        return MILLION;
      }
      return MILLION.concat(SPACE).concat(Thousands.get(tokens[BASE_IDX]));
    }
    if (0L == tokens[BASE_IDX]) {
      return Thousands.get(tokens[MILLION_IDX]).concat(SPACE).concat(MILLIONS);
    }
    return Thousands.get(tokens[MILLION_IDX]).concat(SPACE).concat(MILLIONS)
        .concat(SPACE).concat(Thousands.get(tokens[BASE_IDX]));
  }

}
