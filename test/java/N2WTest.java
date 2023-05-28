import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.n2w.N2W;

import fixtures.LanguajeExceptionProviders;
import fixtures.MinimalProviders;

@TestMethodOrder(MethodOrderer.MethodName.class)
class N2WTest {

  private static final String PARAMETERIZED_TEST_MESSAGE =
      "Number \"{0}\" toWords equivalence is \"{1}\"";

  @Test
  void should_throw_IllegalArgumentException_when_recives_negative() {
    N2W translator = new N2W();

    Exception exception =
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          translator.toWords(-1);
        });

    Assertions.assertEquals(IllegalArgumentException.class,
        exception.getClass());
  }

  @Test
  void should_throw_IllegalArgumentException_when_number_higer_max_value() {
    N2W translator = new N2W();

    Exception exception =
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
          translator.toWords(1000000000);
        });

    Assertions.assertEquals(IllegalArgumentException.class,
        exception.getClass());
  }

  @ParameterizedTest(name = PARAMETERIZED_TEST_MESSAGE)
  @ArgumentsSource(MinimalProviders.class)
  void should_return_number_in_words(int number, String words) {
    N2W translator = new N2W();

    Assertions.assertEquals(words, translator.toWords(number));
  }

  @ParameterizedTest(name = PARAMETERIZED_TEST_MESSAGE)
  @ArgumentsSource(LanguajeExceptionProviders.class)
  void should_return_number_in_words_es_ES_exceptions(int number,
      String words) {
    N2W translator = new N2W();

    Assertions.assertEquals(words, translator.toWords(number));
  }

}
