package Utils;

import java.util.Scanner;

public class NumberUtils {

  public int toInt(String value) {
    while (true) {
      try {
        return Integer.parseInt(value);
      } catch (Exception e) {
        System.err.println("Not a number...");
        System.out.println("Try again.");
        value = new Scanner(System.in).nextLine();
      }
    }
  }

}
