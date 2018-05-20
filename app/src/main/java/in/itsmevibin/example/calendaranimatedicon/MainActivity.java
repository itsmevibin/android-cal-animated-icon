package in.itsmevibin.example.calendaranimatedicon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import in.itsmevibin.example.calendaranimatedicon.flipper.FlipSpinner;

public class MainActivity extends AppCompatActivity {

  private FlipSpinner flipSpinner;
  Button startBt;
  EditText maxLimitEt;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    flipSpinner = findViewById(R.id.flip_spinner);
    maxLimitEt = findViewById(R.id.end_limit_et);
    startBt = findViewById(R.id.start_bt);

    startBt.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startAnimationWith(maxLimitEt.getText().toString());
      }
    });
  }

  private void startAnimationWith(String maxLimit) {
    if (maxLimit.isEmpty()) {
      return;
    }

    flipSpinner.flipTo(maxLimit, true);
  }
}
