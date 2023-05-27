package org.n2w;

public class Thousands {

  private static final int BASE_IDX = 0;
  private static final int THOUSAND_IDX = 1;

  private static final String THOUSAND = "mil";

  private static final String SPACE = " ";

  public static String get(Long number) {
    long[] tokens = Tokenizer.get(number, 3);

    if (1L == tokens[THOUSAND_IDX]) {
      if (0L == tokens[BASE_IDX]) {
        return THOUSAND;
      }
      return THOUSAND.concat(SPACE).concat(Hundreds.get(tokens[BASE_IDX]));
    }
    if (0L == tokens[THOUSAND_IDX]) {
      return Hundreds.get(tokens[BASE_IDX]);
    }
    if (0L == tokens[BASE_IDX]) {
      return Hundreds.get(tokens[THOUSAND_IDX]).concat(SPACE).concat(THOUSAND);
    }
    return Hundreds.get(tokens[THOUSAND_IDX]).concat(SPACE).concat(THOUSAND)
        .concat(SPACE).concat(Hundreds.get(tokens[BASE_IDX]));
  }

}
