import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.n2w.N2W;

@TestMethodOrder(MethodOrderer.MethodName.class)
class N2WTest {

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

}
