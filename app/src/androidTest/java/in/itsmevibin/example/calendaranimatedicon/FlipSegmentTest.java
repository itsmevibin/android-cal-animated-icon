package in.itsmevibin.example.calendaranimatedicon;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import in.itsmevibin.example.calendaranimatedicon.flipper.FlipSegment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class) public class FlipSegmentTest {
  Context appContext = InstrumentationRegistry.getTargetContext();
  FlipSegment flipSegment;

  @Before public void setUp() {
    flipSegment = new FlipSegment(appContext);
  }

  @Test public void textPropertiesTest() {
    flipSegment.setText("16");
    flipSegment.setTextColor(R.color.colorPrimary);
    flipSegment.setTextSize(10f);
    assertThat(flipSegment.getText(), equalTo("16"));
    assertThat(flipSegment.getTextColor(), equalTo(R.color.colorPrimary));
    assertThat(flipSegment.getTextSize(), equalTo(10f));
  }
}
