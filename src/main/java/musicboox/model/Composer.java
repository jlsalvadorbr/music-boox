package musicboox.model;

import java.util.Date;

public class Composer {
  
  private int id;
  private String firstName;
  private String lastName;
  private String nationality;
  private Date birthDate;
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getNationality() {
    return nationality;
  }
  
  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
  
  public Date getBirthDate() {
    return birthDate;
  }
    
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }
}