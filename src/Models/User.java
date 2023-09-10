package Models;

import java.util.UUID;

public class User {

  // #region Attributes
  protected String id;
  private Profile profile;
  private String username;
  private String password;
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
    return this.password.replace(password, "••••••••");
  }

  public void setPassword(String password) {
    this.password = password;
  }
  // #endregion

  // #region Overrides methods
  @Override
  public String toString() {
    return "User ID: " + this.id + "\n" +
        "Username: " + this.username + "\n" +
        "Password: " + this.getPassword() + "\n" +
        "Profile detail:\n" +
        this.profile;
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
  }
  // #endregion
}
