package in.itsmevibin.example.calendaranimatedicon.flipper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import in.itsmevibin.example.calendaranimatedicon.R;

public class FlipSpinner extends RelativeLayout {

  private View flipMeterSpinner = null;

  private FlipView flipView = null;

  public FlipSpinner(Context context) {
    super(context);
    init(null, 0);
  }

  public FlipSpinner(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public FlipSpinner(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    init(attrs, defStyle);
  }

  public void flipTo(String maxLimit, boolean animate) {
    flipView.flipTo(maxLimit, animate);
  }

  public String getString() {
    return flipView.getString();
  }

  private void inflateLayout(int layoutResourceId) {
    LayoutInflater layoutInflater =
        (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    assert layoutInflater != null;
    flipMeterSpinner = layoutInflater.inflate(layoutResourceId, this);
  }

  private void init(AttributeSet attrs, int defStyle) {
    final TypedArray a =
        getContext().obtainStyledAttributes(attrs, R.styleable.FlipSpinner, defStyle, 0);

    int layoutResourceId =
        a.getResourceId(R.styleable.FlipSpinner_view_layout, R.layout.view_flip_spinner_default);
    inflateLayout(layoutResourceId);

    flipView = new FlipView(getContext(), flipMeterSpinner);
  }
}
