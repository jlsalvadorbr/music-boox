package musicboox.repository.jdbc;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.Connection;
import musicboox.repository.jdbc.JdbcConfiguration.JdbcProperty;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class JdbcConnectionFactoryIntegrationTest {
  
  @Mock private JdbcConfiguration jdbcConfiguration;
  private JdbcConnectionFactory jdbcConnectionFactory;
  private Connection connection;
  
  @Before
  public void setUp() throws Exception {
    initMocks(this);
    when(jdbcConfiguration.getProperty(JdbcProperty.DRIVER_CLASSNAME))
      .thenReturn("org.hsqldb.jdbc.JDBCDriver");
    when(jdbcConfiguration.getProperty(JdbcProperty.URL))
      .thenReturn("jdbc:hsqldb:res:db/hsqldb/music-boox-db-test");
    when(jdbcConfiguration.getProperty(JdbcProperty.USERNAME)).thenReturn("SA");
    when(jdbcConfiguration.getProperty(JdbcProperty.PASSWORD)).thenReturn("");
    jdbcConnectionFactory = JdbcConnectionFactory.getInstance(jdbcConfiguration);
  }
  
  @After
  public void tearDown() throws Exception {
    if (connection != null) {
      connection.close();
    }
  }
  
  @Test  
  public void testGetInstance() throws Exception {
    //Given
    JdbcConnectionFactory jdbcConnectionFactory2 = 
        JdbcConnectionFactory.getInstance(jdbcConfiguration);
    //Then
    assertSame(jdbcConnectionFactory, jdbcConnectionFactory2);
  }
  
  
  @Test  
  public void testCreateConnnection() throws Exception {
    
    //When
    connection = jdbcConnectionFactory.createConnection();
    
    //Then
    assertTrue(connection.isValid(5));
  }
}