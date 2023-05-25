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
