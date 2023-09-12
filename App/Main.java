import Controllers.UserController;
import Views.Menu;

class Main {

  public static void main(String[] args) {
    UserController uc = new UserController();
    Menu menu = new Menu();

    // Create Admin user
    uc.createAdmin();

    // Start app
    menu.entryMenu();

  }
}