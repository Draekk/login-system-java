package Utils;

public class TextDecoration {

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
  }
}
