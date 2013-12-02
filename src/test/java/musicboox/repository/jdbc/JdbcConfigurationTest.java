package musicboox.repository.jdbc;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Properties;

import musicboox.repository.jdbc.JdbcConfiguration.JdbcProperty;

import org.junit.*;
import org.mockito.Mock;

public class JdbcConfigurationTest {
	
	@Mock private Properties jdbcProperties;
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		when(jdbcProperties.getProperty("jdbc.driverClassName")).thenReturn("driver.classname");
		when(jdbcProperties.getProperty("jdbc.url")).thenReturn("jdbc:url");
		when(jdbcProperties.getProperty("jdbc.username")).thenReturn("user");
		when(jdbcProperties.getProperty("jdbc.password")).thenReturn("password");
	}
	
	@Test	
	public void testGetProperty() throws Exception {
		
		//Given
		JdbcConfiguration jdbcConfiguration = new JdbcConfiguration(jdbcProperties);

		//Then
		assertEquals("driver.classname", jdbcConfiguration.getProperty(JdbcProperty.DRIVER_CLASSNAME));
		assertEquals("jdbc:url", jdbcConfiguration.getProperty(JdbcProperty.URL));
		assertEquals("user", jdbcConfiguration.getProperty(JdbcProperty.USERNAME));
		assertEquals("password", jdbcConfiguration.getProperty(JdbcProperty.PASSWORD));
	}
}