package org.n2w;

public class Thousands {

  private static final int TOKENS_1_IDX = 0;
  private static final int TOKENS_2_IDX = 1;

  private static final int UNIT_IDX = 0;
  private static final int TENS_IDX = 1;
  private static final int HUNDREDS_IDX = 2;

  private static final String L1XXX = "mil";

  private static final String SPACE = " ";

  public static String get(Long number) {
    long[] tokens = tokenize(number, 3);
    long[] tokens1 = tokenize(tokens[TOKENS_1_IDX], 1);
    long[] tokens2 = tokenize(tokens[TOKENS_2_IDX], 1);
    if (0L == tokens2[HUNDREDS_IDX]//
        && 0L == tokens2[TENS_IDX] //
        && 1L == tokens2[UNIT_IDX]) {
      if (0L == tokens1[HUNDREDS_IDX]//
          && 0L == tokens1[TENS_IDX] //
          && 0L == tokens1[UNIT_IDX]) {
        return L1XXX;
      }
      return L1XXX.concat(SPACE).concat(Hundreds.get(tokens1));
    }
    if (0L == tokens2[HUNDREDS_IDX]//
        && 0L == tokens2[TENS_IDX] //
        && 0L == tokens2[UNIT_IDX]) {
      return Hundreds.get(tokens1);
    }
    if (0L == tokens1[HUNDREDS_IDX]//
        && 0L == tokens1[TENS_IDX] //
        && 0L == tokens1[UNIT_IDX]) {
      return Hundreds.get(tokens2).concat(SPACE).concat(L1XXX);
    }
    return Hundreds.get(tokens2).concat(SPACE).concat(L1XXX).concat(SPACE)
        .concat(Hundreds.get(tokens1));
  }

  private static long[] tokenize(Long number, int tokenLength) {
    int index = 0;
    long[] tokens = new long[3];
    int base = (int) Math.pow(10, tokenLength);
    while (number > 0) {
      tokens[index] = (number % base);
      number = (number / base);
      index++;
    }
    return tokens;
  }

}
