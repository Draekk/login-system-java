package Views;

import java.util.Scanner;

import Controllers.AuthenticationController;
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
            registerMenu();
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
        AuthenticationController ac = new AuthenticationController();
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

  public boolean registerMenu() {
    while (true) {
      try {
        OtherUtils ou = new OtherUtils();
        NumberUtils nu = new NumberUtils();
        UserController uc = new UserController();
        AuthenticationController ac = new AuthenticationController();
        Scanner sc = new Scanner(System.in);

        OtherUtils.consoleClear();
        ou.decorateTitle("Register", '*');
        System.out.println("Please complete every field:");
        System.out.println("First name:");
        String _name = sc.nextLine();
        System.out.println();
        System.out.println("Last name:");
        String _lastName = sc.nextLine();
        System.out.println();
        System.out.println("Age:");
        int _age = nu.toInt(sc.nextLine());
        System.out.println();
        System.out.println("Email:");
        String _email = sc.nextLine();
        System.out.println();
        String _username = "";
        String _password = "";
        while (true) {
          System.out.println("Username:");
          _username = sc.nextLine();
          User compareUser = uc.searchUser(_username);
          if (compareUser == null)
            break;
          else
            System.out.println("Username already exist");
        }
        while (true) {
          System.out.println();
          System.out.println("Password:");
          _password = sc.nextLine();
          System.out.println();
          System.out.println("Repeat password");
          if (_password.equals(sc.nextLine())) {
            System.out.println();
            break;
          } else {
            System.out.println("The passwords aren't the same, try again...");
            System.out.println();
          }
        }
        User newUser = new User(_username, _password, _name, _lastName, _email, _age);
        if (uc.addUser(newUser)) {
          System.out.println("User has been registered correctly.");
          OtherUtils.pressEnter();
          OtherUtils.consoleClear();
          return true;
        }
      } catch (Exception e) {
        System.err.println("An error has occurred: " + e.getMessage());
      }
    }
  }
}
