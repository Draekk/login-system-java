package Views;

import java.util.Scanner;

import Controllers.AutenticationController;
import Controllers.UserController;
import Utils.NumberUtils;
import Utils.OtherUtils;
import Models.User;

public class Menu {

  /**
   * Shows the entry menu
   */
  public void entryMenu() {
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
            if (loginMenu()) {
              System.out.println("You have logged in");
              OtherUtils.pressEnter();
            }
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
            throw new Exception("Invalid option");
        }
      } catch (Exception e) {
        System.err.println("An error has occurred: " + e.getMessage());
        OtherUtils.pressEnter();
      }
    }
  }

  private boolean loginMenu() {
    while (true) {
      try {
        OtherUtils ou = new OtherUtils();
        UserController uc = new UserController();
        AutenticationController ac = new AutenticationController();
        Scanner sc = new Scanner(System.in);

        OtherUtils.consoleClear();
        ou.decorateTitle("Login", '*');
        System.out.println("Username:");
        String _username = sc.nextLine();
        System.out.println("Password:");
        String _password = sc.nextLine();
        return ac.loginProcess(_username, _password);
      } catch (Exception e) {
        System.err.println("An error has occurred: " + e.getMessage());
      }
    }
  }
}
