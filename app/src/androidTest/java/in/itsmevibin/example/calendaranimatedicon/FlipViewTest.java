package in.itsmevibin.example.calendaranimatedicon;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.view.LayoutInflater;
import android.view.View;
import in.itsmevibin.example.calendaranimatedicon.flipper.FlipView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class) public class FlipViewTest {
  Context appContext = InstrumentationRegistry.getTargetContext();
  FlipView flipView;

  @Before public void setUp() {
    View view = LayoutInflater.from(appContext).inflate(R.layout.view_flip_spinner_default, null);
    flipView = new FlipView(appContext, view);
  }

  @Test public void textChangeTest() {
    flipView.flipTo("19", false);
    assertThat(flipView.getString(), equalTo("19"));
  }
}
