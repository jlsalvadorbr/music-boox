package musicboox.repository.jdbc;


import java.io.IOException;
import java.sql.*;

import musicboox.repository.RepositoryException;
import musicboox.repository.jdbc.JdbcConfiguration.JdbcProperty;

public class JdbcConnectionFactory {
	
 	private static JdbcConnectionFactory jdbcConnectionFactory;
    private static JdbcConfiguration jdbcConfiguration;

    private JdbcConnectionFactory(JdbcConfiguration jdbcProperties) {
	 	try {
	 		jdbcConfiguration = jdbcProperties;
	 		Class.forName(jdbcConfiguration.getProperty(JdbcProperty.DRIVER_CLASSNAME));
	 	} catch (ClassNotFoundException e) {
	 		throw new RepositoryException(e);
	 	} catch (IOException e) {
	 		throw new RepositoryException(e);
	 	}
	}

    public static JdbcConnectionFactory getInstance(JdbcConfiguration jdbcConfiguration) {
    	if (jdbcConnectionFactory == null) {
    		jdbcConnectionFactory = new JdbcConnectionFactory(jdbcConfiguration);
        }
        return jdbcConnectionFactory;
    }
 
	public Connection createConnection() {
		try {
			return DriverManager.getConnection(
				jdbcConfiguration.getProperty(JdbcProperty.URL),
				jdbcConfiguration.getProperty(JdbcProperty.USERNAME),
				jdbcConfiguration.getProperty(JdbcProperty.PASSWORD));
		} catch (SQLException e) {
			throw new RepositoryException(e);
		} catch (IOException e) {
			throw new RepositoryException(e);
		}	
	 }

	static JdbcConfiguration getJdbcConfiguration() {
		return jdbcConfiguration;
	}
}