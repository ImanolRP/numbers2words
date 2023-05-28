package org.n2w;

import org.n2w.locale.EsEsDictionary;

public class N2W {

  private static final long MIN_NUMBER = 0L;
  private static final long MAX_NUMBER = 999999999L;

  private Dictionary dictionary;

  public N2W() {
    this.dictionary = new EsEsDictionary();
  }

  public String toWords(int number) {

    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException();
    }

    return this.dictionary.translate(number);
  }

}
