import Database.LoginDB;
import Models.User;
import Controllers.UserController;

import java.util.ArrayList;

class Main {

  public static void main(String[] args) throws CloneNotSupportedException {

    LoginDB.userDatabase = new ArrayList<User>();

    User user1 = new User("admin", "1234", "Gever", "Rodriguez", "garf@correo.com", 31);
    UserController uController = new UserController();
    uController.addUser(user1);

  }

}