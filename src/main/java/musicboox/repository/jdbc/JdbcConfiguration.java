package musicboox.repository.jdbc;

import java.io.IOException;
import java.util.Properties;

public class JdbcConfiguration {
  
  private Properties jdbcProperties; 

  public enum JdbcProperty {
    DRIVER_CLASSNAME("jdbc.driverClassName"),
    URL("jdbc.url"),
    USERNAME("jdbc.username"),
    PASSWORD("jdbc.password");

    private String propertyKey;

    private JdbcProperty(String propertyKey) {
      this.propertyKey = propertyKey;
    }

    String getPropertyKey() {
      return propertyKey;
    }
  }

  public JdbcConfiguration(Properties jdbcProperties) {
    this.jdbcProperties = jdbcProperties;
  }

  public String getProperty(JdbcProperty jdbcProperty) throws IOException {
    return jdbcProperties.getProperty(jdbcProperty.getPropertyKey());
  }
}