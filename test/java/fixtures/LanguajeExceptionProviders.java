package fixtures;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LanguajeExceptionProviders implements ArgumentsProvider {

  private static final HashMap<Long, String> provider =
      new HashMap<Long, String>() {
        private static final long serialVersionUID = 1037291664336460794L;
        {
          put(10L, "diez");
          put(11L, "once");
          put(12L, "doce");
          put(13L, "trece");
          put(14L, "catorce");
          put(15L, "quince");
          put(16L, "dieciséis");
          put(17L, "diecisiete");
          put(18L, "dieciocho");
          put(19L, "diecinueve");
        }
      };

  @Override
  public Stream<? extends Arguments> provideArguments(
      ExtensionContext extensionContext) {
    return provider.entrySet().stream().sorted(Map.Entry.comparingByKey())
        .map((entry) -> Arguments.of(entry.getKey(), entry.getValue()));
  }
}
