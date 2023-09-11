package Utils;

public class OtherUtils {

  /**
   * Creates a border title
   * 
   * @param title      String title that you wants to show
   * @param borderChar Selected char to make te border
   */
  public void decorateTitle(String title, char borderChar) {
    int titleLength = title.length() % 2 == 0 ? title.length() + 2 : title.length() + 1;
    String border = "";
    String margin = "";

    for (int i = 0; i < titleLength + title.length(); i++) {
      border += borderChar;
    }
    for (int i = 0; i < title.length() / 2; i++) {
      margin += " ";
    }
    System.out.println(border);
    System.out.println("|" + margin + title + margin + "|");
    System.out.println(border);
    System.out.println();
  }

  public static void consoleClear() {
    System.out.print("\033[2J\033[H");
  }
}
