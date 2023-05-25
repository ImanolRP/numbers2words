import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.n2w.Numbers2Words;

import fixtures.MinimalProviders;

class Numbers2WordsTest {

  @ParameterizedTest(name = "Number \"{0}\" toWords equivalence is \"{1}\"")
  @ArgumentsSource(MinimalProviders.class)
  void should_return_number_in_words(Long number, String words) {
    Assertions.assertEquals(Numbers2Words.toWords(number), words);
  }

}
