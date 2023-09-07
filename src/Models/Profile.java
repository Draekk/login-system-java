package src.Models;

import java.util.UUID;

public class Profile {

  // #region Attributes
  private UUID id;
  private String name;
  private String lastName;
  private String email;
  private int age;

  // #endregion

  // #region Getters and Setters
  public UUID getId() {
    return this.id;
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
    return "ID: " + this.id + "\n" +
        "Name: " + this.name + "\n" +
        "Last name: " + this.email + "\n";
  }
  // #endregion

  // #region Constructors
  public Profile() {
  }

  public Profile(String name, String lastName, String email, int age) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.age = age;
  }
  // #endregion

}
