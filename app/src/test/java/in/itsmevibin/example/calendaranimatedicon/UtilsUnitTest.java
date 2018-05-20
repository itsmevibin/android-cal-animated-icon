package in.itsmevibin.example.calendaranimatedicon;

import in.itsmevibin.example.calendaranimatedicon.helper.Utils;
import org.junit.Assert;
import org.junit.Test;

public class UtilsUnitTest {

  @Test public void testInputBelowTen_spinnerValues() {
    String[] expectedArray = { "0", "1", "2", "3" };
    String[] actualResult = Utils.getSpinnerValues("3");
    Assert.assertArrayEquals(expectedArray, actualResult);
  }

  @Test public void testInputAboveTen_spinnerValues() {
    String[] expectedArray = { "0", "1", "2", "6", "8", "10", "12", "13", "14", "15" };
    String[] actualResult = Utils.getSpinnerValues("15");
    Assert.assertArrayEquals(expectedArray, actualResult);
  }
}
