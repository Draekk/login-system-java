package Views;

import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;

import Utils.NumberUtils;
import Utils.OtherUtils;

public class Menu {

  public static void entryMenu() {
    while (true) {
      try {
        OtherUtils ou = new OtherUtils();
        NumberUtils nu = new NumberUtils();
        Scanner sc = new Scanner(System.in);

        OtherUtils.consoleClear();
        ou.decorateTitle("Login System", '=');
        System.out.println("Select an option:\n1. Login\n2. Register\n3. Exit");
        String selection = sc.nextLine();
        switch (nu.toInt(selection)) {
          case 1:
            OtherUtils.consoleClear();
            System.out.println("Login menu");
            break;

          case 2:
            OtherUtils.consoleClear();
            System.out.println("Register menu");
            break;

          case 3:
            OtherUtils.consoleClear();
            System.out.println("Exit");
            return;

          default:
            throw new Exception("Invalid value");
        }
      } catch (Exception e) {
        System.err.println("An error has occurred: " + e.getMessage());
        break;
      }
    }
  }
}
