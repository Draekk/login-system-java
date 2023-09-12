package Utils;

import java.util.Scanner;

public class NumberUtils {

  /**
   * Secure parse from string to int
   * 
   * @param value string to parse
   * @return {@code true} if the parse is completed correctly
   */
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

  /**
   * Secure parse from string to float
   * 
   * @param value string to parse
   * @return {@code true} if the parse is completed correctly
   */
  public float toFloat(String value) {
    while (true) {
      try {
        return Float.parseFloat(value);
      } catch (Exception e) {
        System.err.println("Not a number...");
        System.out.println("Try again.");
        value = new Scanner(System.in).nextLine();
      }
    }
  }

}
