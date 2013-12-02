package musicboox.repository.jdbc;

import java.io.IOException;

import musicboox.repository.*;

public class JdbcRepositoryFactory extends RepositoryFactory {
	
    private static JdbcRepositoryFactory jdbcDAOFactory;
    private JdbcConnectionFactory jdbcConnectionFactory;
    
    private JdbcRepositoryFactory(JdbcConfiguration jdbcConfiguration) {
   		jdbcConnectionFactory = JdbcConnectionFactory.getInstance(jdbcConfiguration);
    }    
    
    public static JdbcRepositoryFactory getInstance(JdbcConfiguration jdbcConfiguration) throws IOException {
    	if (jdbcDAOFactory == null) {
    		jdbcDAOFactory = new JdbcRepositoryFactory(jdbcConfiguration);
        }
        return jdbcDAOFactory;
    }

	public ComposerRepository getComposerRepository() {
	    return new JdbcComposerRepositoryImpl(jdbcConnectionFactory);
	}
	
	public PieceRepository getPieceRepository() {
	    return new JdbcPieceRepositoryImpl(jdbcConnectionFactory);
	}
}