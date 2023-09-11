package Models;

import java.util.UUID;

public class User implements Cloneable {

  // #region Attributes
  protected String id;
  private Profile profile;
  private String username;
  private String password;
  private UserType userType;
  // #endregion

  // #region Getters and Setters
  public String getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password.replace(password, "********");
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserType getUserType() {
    return this.userType;
  }

  public void setUserType(int index) {
    try {
      switch (index) {
        case 0:
          this.userType = UserType.ADMIN;
          break;
        case 1:
          this.userType = UserType.MODERATOR;
          break;
        case 2:
          this.userType = UserType.MEMBER;
          break;
        default:
          throw new Exception("Index out of range. Index should be between 0 and 2.");
      }
    } catch (Exception e) {
      System.err.println("An error has occurred: " + e.getMessage());
    }
  }
  // #endregion

  // #region Overrides methods
  @Override
  public String toString() {
    return "User ID: " + this.id + "\n" +
        "Username: " + this.username + "\n" +
        "Password: " + this.getPassword() + "\n" +
        "User Type: " + this.userType + "\n" +
        "Profile detail:\n" +
        this.profile;
  }

  @Override
  public User clone() throws CloneNotSupportedException {
    User clone = (User) super.clone();
    clone.id = this.id;
    clone.username = this.username;
    clone.password = this.password;
    clone.profile = this.profile;
    return clone;
  }
  // #endregion

  // #region Constructors
  public User() {
  }

  public User(String username, String password, String name, String lastName, String email, int age) {
    this.id = UUID.randomUUID().toString().substring(0, 8);
    this.username = username;
    this.password = password;
    this.profile = new Profile(name, lastName, email, age);
    this.profile.setUserId(this.id);
    setUserType(2);
  }
  // #endregion
}
