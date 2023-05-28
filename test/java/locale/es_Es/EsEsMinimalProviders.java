package locale.es_Es;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class EsEsMinimalProviders implements ArgumentsProvider {

  private static final HashMap<Integer, String> provider =
      new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1037291664336460794L;
        {
          put(0, "cero");
          put(1, "uno");
          put(9, "nueve");

          put(10, "diez");
          put(11, "once");
          put(19, "diecinueve");
          put(20, "veinte");
          put(21, "veintiuno");
          put(31, "treinta y uno");
          put(51, "cincuenta y uno");
          put(38, "treinta y ocho");
          put(47, "cuarenta y siete");
          put(99, "noventa y nueve");

          put(100, "cien");
          put(101, "ciento uno");
          put(109, "ciento nueve");
          put(110, "ciento diez");
          put(111, "ciento once");
          put(119, "ciento diecinueve");
          put(199, "ciento noventa y nueve");
          put(999, "novecientos noventa y nueve");

          put(1000, "mil");
          put(1001, "mil uno");
          put(1011, "mil once");
          put(1021, "mil veintiuno");
          put(2019, "dos mil diecinueve");
          put(8048, "ocho mil cuarenta y ocho");
          put(9000, "nueve mil");
          put(9001, "nueve mil uno");
          put(9011, "nueve mil once");
          put(9021, "nueve mil veintiuno");
          put(9999, "nueve mil novecientos noventa y nueve");

          put(11000, "once mil");
          put(11001, "once mil uno");
          put(11011, "once mil once");
          put(11021, "once mil veintiuno");
          put(12002, "doce mil dos");
          put(99000, "noventa y nueve mil");
          put(99001, "noventa y nueve mil uno");
          put(99011, "noventa y nueve mil once");
          put(99021, "noventa y nueve mil veintiuno");

          put(1000000, "un millón");
          put(1000001, "un millón uno");
          put(1000011, "un millón once");
          put(1000021, "un millón veintiuno");
          put(1010000, "un millón diez mil");
          put(1010001, "un millón diez mil uno");
          put(1021001, "un millón veintiún mil uno");
          put(1110000, "un millón ciento diez mil");
          put(2000040, "dos millones cuarenta");
          put(10000000, "diez millones");
          put(11000000, "once millones");
          put(21000000, "veintiún millones");
          put(999999999,
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
