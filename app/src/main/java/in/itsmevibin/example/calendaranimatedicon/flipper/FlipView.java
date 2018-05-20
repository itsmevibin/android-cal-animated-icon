package in.itsmevibin.example.calendaranimatedicon.flipper;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import in.itsmevibin.example.calendaranimatedicon.R;
import in.itsmevibin.example.calendaranimatedicon.helper.Utils;

public class FlipView {

  private FlipSegment flipSegmentBackUpper;
  private FlipSegment flipSegmentBackLower;
  private FlipSegment flipSegmentFrontUpper;
  private FlipSegment flipSegmentFrontLower;

  private Context context;

  private Animation animationUpper;
  private Animation animationLower;
  private Interpolator interpolatorUpper;
  private Interpolator interpolatorLower;

  private String[] stringValues = { "0" };

  private int animateTo = 0;
  private int animateFrom = 0;

  public FlipView(Context context, View view) {
    super();

    this.context = context;

    flipSegmentBackUpper = view.findViewById(R.id.flip_spinner_back_upper);
    flipSegmentBackLower = view.findViewById(R.id.flip_spinner_back_lower);
    flipSegmentFrontUpper = view.findViewById(R.id.flip_spinner_front_upper);
    flipSegmentFrontLower = view.findViewById(R.id.flip_spinner_front_lower);

    init();
  }

  public String getString() {
    return stringValues[animateTo];
  }

  public void flipTo(String maxLimit, boolean animate) {
    setStringValues(Utils.getSpinnerValues(maxLimit));
    setDefaultValues();
    setStringIndex(animate);
  }

  private AnimationListener forwardAnimationListener = new AnimationListener() {
    @Override public void onAnimationStart(Animation animation) {
      if (animation == animationUpper) {
        flipSegmentFrontLower.setVisibility(View.INVISIBLE);
        flipSegmentFrontUpper.setVisibility(View.VISIBLE);

        int index = getIndexToShow();

        setStringByIndexToView(index, flipSegmentFrontLower);
        setStringByIndexToView(index, flipSegmentBackUpper);
      } else if (animation == animationLower) {
        flipSegmentFrontLower.setVisibility(View.VISIBLE);
      }
    }

    @Override public void onAnimationEnd(Animation animation) {
      if (animation == animationUpper) {
        flipSegmentFrontUpper.setVisibility(View.INVISIBLE);

        startSegmentAnimation(false);
      } else if (animation == animationLower) {
        flipSegmentFrontUpper.setVisibility(View.VISIBLE);

        int index = getIndexToShow();

        setStringByIndexToView(index, flipSegmentFrontUpper);
        setStringByIndexToView(index, flipSegmentBackLower);

        animateString();
      }
    }

    @Override public void onAnimationRepeat(Animation animation) {
    }
  };

  private void setStringValues(String[] values) {
    this.stringValues = values;
  }

  private String getStringByIndex(int index) {
    return stringValues[index];
  }

  private void setStringIndex(boolean animate) {
    animateTo = stringValues.length - 1;
    if (animate) {
      setupAnimations(forwardAnimationListener, interpolatorUpper, interpolatorLower);
      animateString();
    } else {
      setStringByIndexToAllViews(animateTo);
    }
  }

  private void setDefaultValues() {
    flipSegmentBackUpper.setText("0");
    flipSegmentBackLower.setText("0");
    flipSegmentFrontUpper.setText("0");
    flipSegmentFrontLower.setText("0");
    flipSegmentBackUpper.setTag(0);
    flipSegmentBackLower.setTag(0);
    flipSegmentFrontUpper.setTag(0);
    flipSegmentFrontLower.setTag(0);
  }

  private void setupAnimations(AnimationListener animationListener, Interpolator interpolatorUpper,
      Interpolator interpolatorLower) {

    animationUpper.setAnimationListener(animationListener);
    animationLower.setAnimationListener(animationListener);

    animationUpper.setInterpolator(interpolatorUpper);
    animationLower.setInterpolator(interpolatorLower);
  }

  private void animateString() {
    animateFrom = getLastIndex();

    if (animateTo != animateFrom) {
      startSegmentAnimation(true);
    }
  }

  private void init() {
    flipSegmentBackUpper.setTag(0);
    flipSegmentBackLower.setTag(0);
    flipSegmentFrontUpper.setTag(0);
    flipSegmentFrontLower.setTag(0);

    animationUpper = AnimationUtils.loadAnimation(context, R.anim.flip_point_to_middle);
    interpolatorUpper = animationUpper.getInterpolator();
    animationLower = AnimationUtils.loadAnimation(context, R.anim.flip_point_from_middle);
    interpolatorLower = animationLower.getInterpolator();
  }

  private void startSegmentAnimation(boolean isUpper) {
    if (isUpper) {
      flipSegmentFrontUpper.clearAnimation();
      flipSegmentFrontUpper.setAnimation(animationUpper);
      flipSegmentFrontUpper.startAnimation(animationUpper);
    } else {
      flipSegmentFrontLower.clearAnimation();
      flipSegmentFrontLower.setAnimation(animationLower);
      flipSegmentFrontLower.startAnimation(animationLower);
    }
  }

  private int getLastIndex() {
    int index = 0;
    try {
      index = (Integer) flipSegmentFrontUpper.getTag();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return normalizeIndex(index);
  }

  private int getIndexToShow() {
    int index;

    if (animateTo == animateFrom) {
      index = animateTo;
    } else {
      index = animateFrom + 1;
    }
    return normalizeIndex(index);
  }

  private int normalizeIndex(int index) {
    return index >= stringValues.length ? 0 : index;
  }

  private void setStringByIndexToAllViews(int index) {
    setStringByIndexToView(index, flipSegmentBackUpper);
    setStringByIndexToView(index, flipSegmentBackLower);
    setStringByIndexToView(index, flipSegmentFrontUpper);
    setStringByIndexToView(index, flipSegmentFrontLower);
  }

  private void setStringByIndexToView(int index, FlipSegment image) {
    image.setTag(index);

    image.setText(getStringByIndex(index));
  }
}