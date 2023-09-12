package Controllers;

import java.util.Scanner;

import Models.User;
import Utils.OtherUtils;

public class AuthenticationController {

  /**
   * Authentication process for login users
   * 
   * @param username Username to login
   * @param password Password to login
   * @return {@code true} if the user is logged in correctly
   */
  public boolean loginProcess(String username, String password) {
    try {
      UserController uc = new UserController();
      User user = uc.searchUser(username);
      if (user != null) {
        if (user.getIsBloqued())
          throw new Exception("This account is bloqued");
        if (user.getPassword().equals(password)) {
          user.setAttempts(3);
          uc.editUser(user);
          return true;
        } else {
          user.setAttempts(user.getAttempts() - 1);
          System.out.println("Wrong password!");
          System.out.printf("Attempts left: %d", user.getAttempts());
          System.out.println("\n");
          if (user.getAttempts() == 0) {
            user.setIsBloqued();
            System.out.println("Your account has been bloqued!");
          }
          uc.editUser(user);
          OtherUtils.pressEnter();
          return false;
        }
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
