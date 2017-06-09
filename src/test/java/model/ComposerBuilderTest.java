package model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import musicboox.model.Composer;
import musicboox.model.ComposerBuilder;

import org.junit.Test;

public class ComposerBuilderTest {

  @Test
  public void testBuild() {

    //Given
    ComposerBuilder composerBuilder = new ComposerBuilder();

    //When
    composerBuilder.withId(9);
    composerBuilder.withFirstName("firstName");
    composerBuilder.withLastName("lastName");
    composerBuilder.withNationality("nationality");
    composerBuilder.withBirthDate(new Date(1900,1,1));
    Composer composer = composerBuilder.build();

    //Then
    assertEquals(9, composer.getId());
    assertEquals("firstName", composer.getFirstName());
    assertEquals("lastName", composer.getLastName());
    assertEquals("nationality", composer.getNationality());
    assertEquals(new Date(1900,1,1), composer.getBirthDate());
  }
}
