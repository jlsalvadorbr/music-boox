package musicboox.model;

import java.util.Date;

public class ComposerBuilder {
  
  private int id;
  private String firstName;
  private String lastName;
  private String nationality;
  private Date birthDate;

  public ComposerBuilder() {
  }
  
  public ComposerBuilder withId(int id) {
    this.id = id;
    return this;
  }
  
  public ComposerBuilder withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }
  
  public ComposerBuilder withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  
  public ComposerBuilder withNationality(String nationality) {
    this.nationality = nationality;
    return this;
  }
  
  public ComposerBuilder withBirthDate(Date birthDate) {
    this.birthDate = birthDate;
    return this;
  }
  
  public Composer build() {
    Composer composer = new Composer();
    composer.setId(id);
    composer.setFirstName(firstName);
    composer.setLastName(lastName);
    composer.setNationality(nationality);
    composer.setBirthDate(birthDate);
    return composer;
  }
}