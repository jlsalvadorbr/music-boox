package musicboox.repository.jdbc;

import static matchers.EqualsExpectedJdbcConfiguration.equalsExpectedJdbcConfiguration;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.sql.Connection;

import musicboox.repository.*;
import musicboox.repository.jdbc.JdbcConfiguration.JdbcProperty;

import org.junit.*;
import org.mockito.Mock;

public class JdbcRepositoryFactoryTest {
	
	@Mock private JdbcConfiguration jdbcConfiguration;
	
	private JdbcRepositoryFactory jdbcRepositoryFactory;
	private Connection connection;
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		when(jdbcConfiguration.getProperty(JdbcProperty.DRIVER_CLASSNAME)).thenReturn("org.hsqldb.jdbc.JDBCDriver");
		when(jdbcConfiguration.getProperty(JdbcProperty.URL)).thenReturn("jdbc:hsqldb:res:db/hsqldb/music-boox-db-test");
		when(jdbcConfiguration.getProperty(JdbcProperty.USERNAME)).thenReturn("SA");
		when(jdbcConfiguration.getProperty(JdbcProperty.PASSWORD)).thenReturn("");
		jdbcRepositoryFactory = JdbcRepositoryFactory.getInstance(jdbcConfiguration);
	}
	
	@Test	
	public void testGetInstance() throws Exception {
		//Given
		JdbcRepositoryFactory jdbcRepositoryFactory2 = JdbcRepositoryFactory.getInstance(jdbcConfiguration);
		//Then
		assertSame(jdbcRepositoryFactory, jdbcRepositoryFactory2);
	}

	@Test	
	public void testGetPieceRepository() throws Exception {
		//Given
		PieceRepository pieceRepository = jdbcRepositoryFactory.getPieceRepository();
		//Then
		assertThat(pieceRepository, instanceOf(JdbcPieceRepositoryImpl.class));
		JdbcConnectionFactory jdbConnectionFactory = ((JdbcPieceRepositoryImpl)pieceRepository).getJdbcConnectionFactory();
		assertThat(jdbcConfiguration, equalsExpectedJdbcConfiguration(jdbConnectionFactory.getJdbcConfiguration()));
	}
	
	@Test	
	public void testGetComposerRepository() throws Exception {
		//Given
		ComposerRepository composerRepository = jdbcRepositoryFactory.getComposerRepository();
		//Then
		assertThat(composerRepository, instanceOf(JdbcComposerRepositoryImpl.class));
		JdbcConnectionFactory jdbConnectionFactory = ((JdbcComposerRepositoryImpl)composerRepository).getJdbcConnectionFactory();
		assertThat(jdbcConfiguration, equalsExpectedJdbcConfiguration(jdbConnectionFactory.getJdbcConfiguration()));
		
	}
}