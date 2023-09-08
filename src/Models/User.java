package src.Models;

import java.util.UUID;

public class User {

  // #region Attributes
  protected UUID id;
  private Profile profile;
  private String username;
  private String password;
  // #endregion

  // #region Getters and Setters
  public UUID getId() {
    return this.id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  // #endregion

  // #region Overrides methos
  @Override
  public String toString() {
    return "ID: " + this.id + "\n" +
        "Username: " + this.username + "\n" +
        "Password: " + this.password + "\n" +
        "Profile detail:\n" +
        this.profile;
  }
  // #endregion

  // #region Constructors
  public User() {
  }

  public User(String username, String password, String name, String lastName, String email, int age) {
    this.id = UUID.randomUUID();
    this.username = username;
    this.password = password;
    this.profile = new Profile(name, lastName, email, age);
    this.profile.setUserId(this.id);
  }
}
