import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.n2w.Numbers2Words;

import fixtures.MinimalProviders;

class Numbers2WordsTest {

  @Test
  void should_throw_NullPointerException() {
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

  @ParameterizedTest(name = "Number \"{0}\" toWords equivalence is \"{1}\"")
  @ArgumentsSource(MinimalProviders.class)
  void should_return_number_in_words(Long number, String words) {
    Assertions.assertEquals(Numbers2Words.toWords(number), words);
  }

}
