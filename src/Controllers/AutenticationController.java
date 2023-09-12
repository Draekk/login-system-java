package Controllers;

import java.util.Scanner;

import Models.User;
import Utils.OtherUtils;

public class AutenticationController {

  public boolean loginProcess(String username, String password) {
    try {
      UserController uc = new UserController();
      User user = uc.searchUser(username);
      if (user != null) {
        if (user.getIsBloqued())
          throw new Exception("This account is bloqued");
        do {
          if (user.getPassword().equals(password)) {
            return true;
          } else {
            user.setAttempts(user.getAttempts() - 1);
            System.out.println("Wrong password!");
            System.out.printf("Attempts left: %d", user.getAttempts());
            System.out.println("\n");
            if (user.getAttempts() > 0) {
              OtherUtils.pressEnter();
              OtherUtils.consoleClear();
              System.out.println("Password:");
              password = new Scanner(System.in).nextLine();
            }
          }
        } while (user.getAttempts() > 0);
        user.setIsBloqued();
        uc.editUser(user);
        System.out.println("Your account has been bloqued!");
        OtherUtils.pressEnter();
      } else {
        System.out.println("Invalid Username.");
        OtherUtils.pressEnter();
      }
      return false;
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
      OtherUtils.pressEnter();
      return false;
    }
  }
}
