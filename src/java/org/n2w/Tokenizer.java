package org.n2w;

public class Tokenizer {

  private Tokenizer() {}

  public static int[] get(int number, int tokenLength) {
    int index = 0;
    int[] tokens = new int[3];
    int base = (int) Math.pow(10, tokenLength);
    while (number > 0) {
      tokens[index] = (number % base);
      number = (number / base);
      index++;
    }
    return tokens;
  }

}
