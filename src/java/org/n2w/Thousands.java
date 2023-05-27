package org.n2w;

public class Thousands {

  private static final int BASE_IDX = 0;
  private static final int THOUSAND_IDX = 1;

  private static final String THOUSAND = "mil";
  private static final String L21 = "veintiún";

  private static final String SPACE = " ";

  private Thousands() {}

  public static String get(Long number) {
    long[] tokens = Tokenizer.get(number, 3);

    if (0L == tokens[THOUSAND_IDX]) {
      return Hundreds.get(tokens[BASE_IDX]);
    }
    if (1L == tokens[THOUSAND_IDX]) {
      if (0L == tokens[BASE_IDX]) {
        return THOUSAND;
      }
      return THOUSAND.concat(SPACE).concat(Hundreds.get(tokens[BASE_IDX]));
    }

    String words;
    if (21L == tokens[THOUSAND_IDX]) {
      words = L21.concat(SPACE).concat(THOUSAND);
    } else {
      words = Hundreds.get(tokens[THOUSAND_IDX]).concat(SPACE).concat(THOUSAND);
    }
    if (0L == tokens[BASE_IDX]) {
      return words;
    }
    return words.concat(SPACE).concat(Hundreds.get(tokens[BASE_IDX]));
  }

}
