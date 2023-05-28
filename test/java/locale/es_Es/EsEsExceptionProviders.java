package locale.es_Es;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class EsEsExceptionProviders implements ArgumentsProvider {

  private static final HashMap<Integer, String> provider =
      new HashMap<Integer, String>() {
        private static final long serialVersionUID = 1037291664336460794L;
        {
          put(10, "diez");
          put(11, "once");
          put(12, "doce");
          put(13, "trece");
          put(14, "catorce");
          put(15, "quince");
          put(16, "dieciséis");
          put(17, "diecisiete");
          put(18, "dieciocho");
          put(19, "diecinueve");

          put(20, "veinte");
          put(22, "veintidós");
          put(23, "veintitrés");
          put(21000, "veintiún mil");
          put(21000000, "veintiún millones");
        }
      };

  @Override
  public Stream<? extends Arguments> provideArguments(
      ExtensionContext extensionContext) {
    return provider.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .map((entry) -> Arguments.of(entry.getKey(), entry.getValue()));
  }
}
