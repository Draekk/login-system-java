package src.Models;

import java.util.UUID;

public class User {

  // #region Attributes
  private UUID id;
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
}
