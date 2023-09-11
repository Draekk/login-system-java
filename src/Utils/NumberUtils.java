package Utils;

public class NumberUtils {

  public int toInt(String value) {
    while (true) {
      try {
        return Integer.parseInt(value);
      } catch (Exception e) {
        System.err.println("Not a number...");
        System.out.println("Try again.");
      }
    }
  }

}
