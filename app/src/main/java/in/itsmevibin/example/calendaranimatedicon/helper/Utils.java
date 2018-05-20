package in.itsmevibin.example.calendaranimatedicon.helper;

import java.util.ArrayList;

public class Utils {

  public static String[] getSpinnerValues(String maxLimitStr) {
    int maxLimit = Integer.parseInt(maxLimitStr);
    return maxLimit > 10 ? Utils.getNormalizeValues(maxLimit) : Utils.getAllValues(maxLimit);
  }

  private static String[] getNormalizeValues(int maxLimit) {
    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add(String.valueOf(0));
    stringArrayList.add(String.valueOf(1));
    stringArrayList.add(String.valueOf(2));

    int diffValue = maxLimit / 7;
    for (int i = 1; i < 10; i++) {
      int value = (i + 2) * diffValue;
      if (maxLimit - 3 < value) break;
      stringArrayList.add(String.valueOf(value));
    }

    stringArrayList.add(String.valueOf(maxLimit - 2));
    stringArrayList.add(String.valueOf(maxLimit - 1));
    stringArrayList.add(String.valueOf(maxLimit));

    return stringArrayList.toArray(new String[0]);
  }

  private static String[] getAllValues(int maxLimit) {
    ArrayList<String> stringArrayList = new ArrayList<>();

    for (int i = 0; i <= maxLimit; i++) {
      stringArrayList.add(String.valueOf(i));
    }

    return stringArrayList.toArray(new String[0]);
  }
}
