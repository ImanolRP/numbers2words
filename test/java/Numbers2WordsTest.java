import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.n2w.Numbers2Words;

import fixtures.LanguajeExceptionProviders;
import fixtures.MinimalProviders;

@TestMethodOrder(MethodOrderer.MethodName.class)
class Numbers2WordsTest {

  private static final String PARAMETERIZED_TEST_MESSAGE =
      "Number \"{0}\" toWords equivalence is \"{1}\"";

  @Test
  void should_throw_NullPointerException_when_recives_null() {
    Exception exception =
        Assertions.assertThrows(NullPointerException.class, () -> {
          Numbers2Words.toWords(null);
        });

    Assertions.assertEquals(NullPointerException.class, exception.getClass());
  }

  @Test
  void should_throw_IllegalArgumentException_when_recives_negative() {
    Exception exception =
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          Numbers2Words.toWords(-1L);
        });

    Assertions.assertEquals(IllegalArgumentException.class,
        exception.getClass());
  }

  @Test
  void should_throw_IllegalArgumentException_when_number_higer_max_value() {
    Exception exception =
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          Numbers2Words.toWords(1000000000L);
        });

    Assertions.assertEquals(IllegalArgumentException.class,
        exception.getClass());
  }

  @ParameterizedTest(name = PARAMETERIZED_TEST_MESSAGE)
  @ArgumentsSource(MinimalProviders.class)
  void should_return_number_in_words(Long number, String words) {
    Assertions.assertEquals(words, Numbers2Words.toWords(number));
  }

  @ParameterizedTest(name = PARAMETERIZED_TEST_MESSAGE)
  @ArgumentsSource(LanguajeExceptionProviders.class)
  void should_return_number_in_words_es_ES_exceptions(Long number,
      String words) {
    Assertions.assertEquals(words, Numbers2Words.toWords(number));
  }

}
