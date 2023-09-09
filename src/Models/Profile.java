package Models;

import java.util.UUID;

public class Profile extends User {

  // #region Attributes
  private String profId;
  private String userId;
  private String name;
  private String lastName;
  private String email;
  private int age;

  // #endregion

  // #region Getters and Setters
  protected void setUserId(String id) {
    this.userId = id;
  }

  public String getProfId() {
    return this.profId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    this.age = age;
  }
  // #endregion

  // #region Overrides methods
  @Override
  public String toString() {
    return "Name: " + this.name + "\n" +
        "Last name: " + this.lastName + "\n" +
        "Email: " + this.email + "\n" +
        "Age: " + this.age + "\n";
  }
  // #endregion

  // #region Constructors
  protected Profile() {
  }

  protected Profile(String name, String lastName, String email, int age) {
    this.profId = UUID.randomUUID().toString().substring(0, 8);
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }
  // #endregion

}
