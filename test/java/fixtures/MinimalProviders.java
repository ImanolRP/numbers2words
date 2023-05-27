package fixtures;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MinimalProviders implements ArgumentsProvider {

  private static final HashMap<Long, String> provider =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 1037291664336460794L;
        {
          put(0L, "cero");
          put(1L, "uno");
          put(9L, "nueve");

          put(10L, "diez");
          put(11L, "once");
          put(19L, "diecinueve");
          put(20L, "veinte");
          put(21L, "veintiuno");
          put(31L, "treinta y uno");
          put(51L, "cincuenta y uno");
          put(38L, "treinta y ocho");
          put(47L, "cuarenta y siete");
          put(99L, "noventa y nueve");

          put(100L, "cien");
          put(101L, "ciento uno");
          put(109L, "ciento nueve");
          put(110L, "ciento diez");
          put(111L, "ciento once");
          put(119L, "ciento diecinueve");
          put(199L, "ciento noventa y nueve");
          put(999L, "novecientos noventa y nueve");

          put(1000L, "mil");
          put(1001L, "mil uno");
          put(1011L, "mil once");
          put(1021L, "mil veintiuno");
          put(2019L, "dos mil diecinueve");
          put(8048L, "ocho mil cuarenta y ocho");
          put(9000L, "nueve mil");
          put(9001L, "nueve mil uno");
          put(9011L, "nueve mil once");
          put(9021L, "nueve mil veintiuno");
          put(9999L, "nueve mil novecientos noventa y nueve");

          put(11000L, "once mil");
          put(11001L, "once mil uno");
          put(11011L, "once mil once");
          put(11021L, "once mil veintiuno");
          put(12002L, "doce mil dos");
          put(99000L, "noventa y nueve mil");
          put(99001L, "noventa y nueve mil uno");
          put(99011L, "noventa y nueve mil once");
          put(99021L, "noventa y nueve mil veintiuno");

          put(1000000L, "un millón");
          put(1000001L, "un millón uno");
          put(1000011L, "un millón once");
          put(1000021L, "un millón veintiuno");
          put(1010000L, "un millón diez mil");
          put(1010001L, "un millón diez mil uno");
          put(1021001L, "un millón veintiún mil uno");
          put(1110000L, "un millón ciento diez mil");
          put(2000040L, "dos millones cuarenta");
          put(10000000L, "diez millones");
          put(11000000L, "once millones");
          put(21000000L, "veintiún millones");
          put(999999999L,
              "novecientos noventa y nueve millones novecientos noventa y nueve mil novecientos noventa y nueve");
        }
      };

  @Override
  public Stream<? extends Arguments> provideArguments(
      ExtensionContext extensionContext) {
    return provider.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .map((entry) -> Arguments.of(entry.getKey(), entry.getValue()));
  }

}
