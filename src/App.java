import Controllers.UserController;
import Views.Menu;

public class App {
    public static void main(String[] args) throws Exception {
        
        UserController uc = new UserController();
        Menu menu = new Menu();
        
        // Create Admin user
        uc.createAdmin();
        
        // Start app
        menu.entryMenu();

    }
}
