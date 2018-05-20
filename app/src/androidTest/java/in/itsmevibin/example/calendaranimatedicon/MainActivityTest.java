package in.itsmevibin.example.calendaranimatedicon;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import in.itsmevibin.example.calendaranimatedicon.flipper.FlipSpinner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class) public class MainActivityTest {
  Context appContext = InstrumentationRegistry.getTargetContext();
  private MainActivity mainActivity;
  FlipSpinner flipSpinner;

  @Before public void setUp() {
    mainActivity = mActivityRule.getActivity();
    flipSpinner = mainActivity.findViewById(R.id.flip_spinner);
  }

  @Rule public ActivityTestRule<MainActivity> mActivityRule =
      new ActivityTestRule(MainActivity.class);

  @Test public void elementsInViewTest() {
    onView(allOf(withId(R.id.start_bt), withText(appContext.getString(R.string.start))));
    onView(withId(R.id.start_bt)).perform(click()).check(matches(isDisplayed()));
    onView(withId(R.id.flip_spinner)).check(matches(isDisplayed()));
    assertThat(flipSpinner.getString(), equalTo("0"));
  }

  @Test public void calendarValueChangeTest() {
    flipSpinner.flipTo("15", false);
    assertThat(flipSpinner.getString(), equalTo("15"));
  }
}