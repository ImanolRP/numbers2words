package locale.es_Es;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.n2w.N2W;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EsEsDictionaryTest {

  private static final String PARAMETERIZED_TEST_MESSAGE =
      "Number \"{0}\" toWords equivalence is \"{1}\"";

  @ParameterizedTest(name = PARAMETERIZED_TEST_MESSAGE)
  @ArgumentsSource(EsEsMinimalProviders.class)
  void should_return_number_in_words(int number, String words) {
    N2W translator = new N2W();

    Assertions.assertEquals(words, translator.toWords(number));
  }

  @ParameterizedTest(name = PARAMETERIZED_TEST_MESSAGE)
  @ArgumentsSource(EsEsExceptionProviders.class)
  void should_return_number_in_words_es_ES_exceptions(int number,
      String words) {
    N2W translator = new N2W();

    Assertions.assertEquals(words, translator.toWords(number));
  }

}
