package Controllers;

import Database.LoginDB;
import Models.User;

import java.util.ArrayList;

public class UserController {
  // #region CRUD User
  /**
   * Adds new user to the user list
   * 
   * @param user user to add.
   * @return {@code true} if the user is added correctly
   */
  public boolean addUser(User user) {
    try {
      if (LoginDB.userDatabase == null)
        LoginDB.userDatabase = new ArrayList<>();
      if (!LoginDB.userDatabase.isEmpty()) {
        for (User u : LoginDB.userDatabase) {
          if (u.getId() == user.getId()) {
            throw new Exception("User already exist.");
          }
        }
      }
      LoginDB.userDatabase.add(user);
      return true;
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
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
            return user.clone();
          }
        }
      }
      return null;
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
      return null;
    }
  }

  /**
   * Sets an existing user with modifications in the user list
   * 
   * @param newUser the user with incomming modification
   * @return {@code true} if the user is set correctly
   */
  public boolean editUser(User newUser) {
    try {
      if (!LoginDB.userDatabase.isEmpty()) {
        for (User user : LoginDB.userDatabase) {
          if (user.getId().equals(newUser.getId())) {
            LoginDB.userDatabase.set(LoginDB.userDatabase.indexOf(user), newUser);
            return true;
          }
        }
        throw new Exception("User not found");
      } else {
        throw new Exception("Empty list");
      }
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
      return false;
    }
  }

  /**
   * Deletes an user from the user list
   * 
   * @param userToDelete user to delete
   * @return {@code true} if the user is deleted correctly
   */
  public boolean deleteUser(User userToDelete) {
    try {
      if (!LoginDB.userDatabase.isEmpty()) {
        for (User user : LoginDB.userDatabase) {
          if (user.getId().equals(userToDelete.getId())) {
            LoginDB.userDatabase.remove(LoginDB.userDatabase.indexOf(user));
            return true;
          }
        }
        throw new Exception("User not found");
      } else {
        throw new Exception("Empty list!");
      }
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
      return false;
    }
  }
  // #endregion

  /**
   * Creates master user
   */
  public void createAdmin() {
    UserController uc = new UserController();
    User admin = new User("admin", "admin", "Gever", "Rodriguez", "rodriver1992@gmail.com", 31);
    admin.setUserType(0);
    uc.addUser(admin);
  }

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
