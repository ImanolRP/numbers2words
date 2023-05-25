package fixtures;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
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
        }
      };

  @Override
  public Stream<? extends Arguments> provideArguments(
      ExtensionContext extensionContext) {
    return provider.entrySet().stream()
        .map((entry) -> Arguments.of(entry.getKey(), entry.getValue()));
  }

}
