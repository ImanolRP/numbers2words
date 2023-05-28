package org.n2w.locale;

import org.n2w.Dictionary;
import org.n2w.Tokenizer;

public class EsEsDictionary implements Dictionary {

  private static final String MILLION = "un millón";
  private static final String MILLIONS = "millones";

  private static final String THOUSAND = "mil";

  private static final String HUNDRED = "cien";

  private static final String SPACE = " ";
  private static final String SEPARATOR = " y ";

  private static final String[] hundredsDictionary =
      {"", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos",
          "seiscientos", "setecientos", "ochocientos", "novecientos"};

  private static final String[] tensDictionary = {"", "", "", "treinta",
      "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

  private static final String[] teensDictionary =
      {"diez", "once", "doce", "trece", "catorce", "quince", "dieciséis",
          "diecisiete", "dieciocho", "diecinueve"};

  private static final String[] unitsDictionary = {"cero", "uno", "dos", "tres",
      "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

  @Override
  public String translate(int number) {
    int[] tokens = Tokenizer.get(number, 6);

    if (0 == tokens[1]) {
      return getThousands(tokens[0]);
    } else if (1 == tokens[1]) {
      if (0 == tokens[0]) {
        return MILLION;
      }
      return MILLION.concat(SPACE).concat(getThousands(tokens[0]));
    }

    String words;
    if (21 == tokens[1]) {
      words = "veintiún".concat(SPACE).concat(MILLIONS);
    } else {
      words = getThousands(tokens[1]).concat(SPACE).concat(MILLIONS);
    }
    if (0 == tokens[0]) {
      return words;
    }
    return words.concat(SPACE).concat(getThousands(tokens[0]));
  }

  private String getThousands(int number) {
    int[] tokens = Tokenizer.get(number, 3);

    if (0 == tokens[1]) {
      return getHundreds(tokens[0]);
    } else if (1 == tokens[1]) {
      if (0 == tokens[0]) {
        return THOUSAND;
      }
      return THOUSAND.concat(SPACE).concat(getHundreds(tokens[0]));
    }

    String words;
    if (21 == tokens[1]) {
      words = "veintiún".concat(SPACE).concat(THOUSAND);
    } else {
      words = getHundreds(tokens[1]).concat(SPACE).concat(THOUSAND);
    }
    if (0 == tokens[0]) {
      return words;
    }
    return words.concat(SPACE).concat(getHundreds(tokens[0]));
  }

  private String getHundreds(int number) {
    int[] tokens = Tokenizer.get(number, 2);

    if (0 == tokens[1]) {
      return getTens(tokens[0]);
    }
    if (100 == number) {
      return HUNDRED;
    }
    return hundredsDictionary[tokens[1]].concat(SPACE)
        .concat(getTens(tokens[0]));
  }

  private String getTens(int number) {
    int[] tokens = Tokenizer.get(number, 1);

    if (0L == tokens[1]) {
      return getUnits(tokens[0]);
    }
    if (1L == tokens[1]) {
      return teensDictionary[tokens[0]];
    }
    if (2L == tokens[1]) {
      if (0L == tokens[0]) {
        return "veinte";
      } else if (2L == tokens[0]) {
        return "veintidós";
      } else if (3L == tokens[0]) {
        return "veintitrés";
      }
      return "veinti".concat(getUnits(tokens[0]));
    }

    String words = tensDictionary[tokens[1]];
    if (0L == tokens[0]) {
      return words;
    }
    return words.concat(SEPARATOR).concat(getUnits(tokens[0]));
  }

  private String getUnits(int number) {
    return unitsDictionary[number];
  }

}
