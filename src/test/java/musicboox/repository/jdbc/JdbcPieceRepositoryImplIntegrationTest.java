package musicboox.repository.jdbc;

import static matchers.EqualsExpectedPiece.equalsExpectedPiece;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import fixtures.PieceFixtures;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import musicboox.model.Piece;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JdbcPieceRepositoryImplIntegrationTest {

  private static JdbcConfiguration jdbcConfiguration;
  private JdbcPieceRepositoryImpl  jdbcPieceRepositoryImpl;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    jdbcConfiguration = readJdbcConfiguration("db/hsqldb/jdbc-config-test.properties");
  }

  private static JdbcConfiguration readJdbcConfiguration(String jdbcConfigFile) throws IOException {
    Properties jdbcProperties = new Properties();
    InputStream is = 
        JdbcPieceRepositoryImplIntegrationTest.class.getClassLoader()
          .getResourceAsStream(jdbcConfigFile);
    try {
      jdbcProperties.load(is);
      return new JdbcConfiguration(jdbcProperties);
    } finally {
      if (is != null) {
        is.close();
      }
    }
  }

  @Before
  public void setUp() throws Exception {
    JdbcConnectionFactory jdbcConnectionFactory =
        JdbcConnectionFactory.getInstance(jdbcConfiguration);
    jdbcPieceRepositoryImpl = new JdbcPieceRepositoryImpl(jdbcConnectionFactory);
  }  

  @Test  
  public void testFindAllPieces() throws Exception {

    //When
    List<Piece> pieces = jdbcPieceRepositoryImpl.findAllPieces();

    //Then
    assertEquals(7, pieces.size());
    assertThat(pieces, contains(
        equalsExpectedPiece(PieceFixtures.MAGIC_FLUTE),
        equalsExpectedPiece(PieceFixtures.DON_GIOVANNI),
        equalsExpectedPiece(PieceFixtures.MARRIAGE_FIGARO),
        equalsExpectedPiece(PieceFixtures.FUR_ELISE),
        equalsExpectedPiece(PieceFixtures.MOONLIGHT_SONATA),
        equalsExpectedPiece(PieceFixtures.PATHETIQUE_SONATA),
        equalsExpectedPiece(PieceFixtures.NINETH_SYMPHONY)));
  }
}