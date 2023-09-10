package Controllers;

import java.util.ArrayList;

import Database.LoginDB;
import Models.User;

public class UserController {
  /**
   * Adds new user to the user list
   * 
   * @param user user to add.
   * @return {@code true} if the user is added correctly
   */
  public boolean addUser(User user) {
    try {
      if (!LoginDB.userDatabase.isEmpty()) {
        for (User u : LoginDB.userDatabase) {
          if (u.getId() == user.getId()) {
            System.out.println("This user already exist.");
            return false;
          } else if (u.getUsername().equals(user.getUsername())) {
            System.out.println("This Username already exist.");
            return false;
          }
        }
        LoginDB.userDatabase.add(user);
        return true;
      } else {
        LoginDB.userDatabase = new ArrayList<>();
        LoginDB.userDatabase.add(user);
        return true;
      }
    } catch (Exception e) {
      System.out.printf("An error has occurred: %s", e.getMessage());
      return false;
    }
  }

  /**
   * Search an user in the user list by its id or its username
   * 
   * @param idOrUsername can be the user id or the user username
   * @return {@code User} if is the user is found,
   *         {@code null} if the user is no found
   */
  public User searchUser(String idOrUsername) {
    try {
      if (!LoginDB.userDatabase.isEmpty()) {
        for (User user : LoginDB.userDatabase) {
          if (user.getId().equals(idOrUsername) || user.getUsername().equals(idOrUsername)) {
            return user;
          }
        }
      }
      return null;
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
      return null;
    }
  }

  // TODO: Method description
  // public boolean editUser(User user) {
  // try {
  // if(!LoginDB.userDatabase.isEmpty()){
  // //get password encrypted
  // // String passEncrypted=EncryptionUtils.encryptPassword(user.<PASSWORD>());
  // }
  // } catch (Exception e) {
  // // TODO: handle exception
  // }
  // }

  /**
   * Shows in console the list of users
   */
  public void showUserList() {
    try {
      if (!LoginDB.userDatabase.isEmpty()) {
        for (User user : LoginDB.userDatabase) {
          System.out.println(user);
        }
      } else {
        System.err.print("The user list is empty");
      }
    } catch (Exception e) {
      System.err.print("An error has occurred: " + e.getMessage());
    }
  }

}
