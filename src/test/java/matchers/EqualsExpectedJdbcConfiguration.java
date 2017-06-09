package matchers;

import java.io.IOException;

import musicboox.repository.jdbc.JdbcConfiguration;
import musicboox.repository.jdbc.JdbcConfiguration.JdbcProperty;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;

public class EqualsExpectedJdbcConfiguration extends TypeSafeMatcher<JdbcConfiguration> {
  
  private final JdbcConfiguration expectedJdbcConfiguration;
  
  private EqualsExpectedJdbcConfiguration(JdbcConfiguration expectedJdbcConfiguration) {
    this.expectedJdbcConfiguration = expectedJdbcConfiguration;
  }

  @Override
  protected boolean matchesSafely(JdbcConfiguration jdbcConfiguration) {
    try {
      if (objectsAreEqual(expectedJdbcConfiguration.getProperty(JdbcProperty.DRIVER_CLASSNAME), 
          jdbcConfiguration.getProperty(JdbcProperty.DRIVER_CLASSNAME)) == false) {
        return false;
      }
      if (objectsAreEqual(expectedJdbcConfiguration.getProperty(JdbcProperty.URL), 
          jdbcConfiguration.getProperty(JdbcProperty.URL)) == false) {
        return false;
      }
      if (objectsAreEqual(expectedJdbcConfiguration.getProperty(JdbcProperty.USERNAME), 
          jdbcConfiguration.getProperty(JdbcProperty.USERNAME)) == false) {
        return false;
      }
      if (objectsAreEqual(expectedJdbcConfiguration.getProperty(JdbcProperty.PASSWORD), 
          jdbcConfiguration.getProperty(JdbcProperty.PASSWORD)) == false) {
        return false;
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return true;
  }
  
  private boolean objectsAreEqual(Object object1, Object object2) {
    return (object1 == null ? object2 == null :
      object1.equals(object2));
  }
  
  @Override
  public void describeTo(Description description) {
    description.appendText("JdbcConfiguration doesn't match expected value");
  }
  
  @Factory
  public static EqualsExpectedJdbcConfiguration 
      equalsExpectedJdbcConfiguration(JdbcConfiguration expectedJdbcConfiguration) {
    return new EqualsExpectedJdbcConfiguration(expectedJdbcConfiguration);
  }  
}