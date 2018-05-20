package in.itsmevibin.example.calendaranimatedicon;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import in.itsmevibin.example.calendaranimatedicon.flipper.FlipSpinner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class) public class FlipSpinnerTest {

  Context appContext = InstrumentationRegistry.getTargetContext();
  FlipSpinner flipSpinner;

  @Before public void setUp() {
    flipSpinner = new FlipSpinner(appContext);
  }

  @Test public void textChangeTest() {
    flipSpinner.flipTo("15", false);
    assertThat(flipSpinner.getString(), equalTo("15"));
  }
}
