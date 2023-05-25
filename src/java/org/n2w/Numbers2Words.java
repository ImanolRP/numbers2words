package org.n2w;

public class Numbers2Words {

  private Numbers2Words() {}

  public static String toWords(Long number) {
    if (1L == number) {
      return "uno";
    }
    return "cero";
  }

}
