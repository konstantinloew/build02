import static org.junit.Assert.*;
import org.junit.Test;

public class HelloWorldHelperTest {
  HelloWorldHelper helper = new HelloWorldHelper();

  @Test
  public void testEnglish() {
    assertTrue(helper.useEnglish().contains("world"));
  }

  @Test
  public void testGerman() {
    assertTrue(helper.useGerman().contains("Welt"));
  }

  @Test
  public void testJapanese() {
    assertTrue(helper.useJapanese().contains("ワールド"));
  }

  @Test
  public void testSpanish() {
    assertTrue(helper.useSpanish().contains("mundo"));
  }

}
