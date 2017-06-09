package musicboox.repository.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import musicboox.model.Composer;
import musicboox.model.Piece;
import musicboox.repository.PieceRepository;
import musicboox.repository.RepositoryException;

public class JdbcPieceRepositoryImpl implements PieceRepository {
  
  private JdbcConnectionFactory jdbcConnectionFactory;
  
  JdbcPieceRepositoryImpl(JdbcConnectionFactory jdbcConnectionFactory) {
    this.jdbcConnectionFactory = jdbcConnectionFactory;
  }

  @Override
  public List<Piece> findPiecesByComposerId(int id) {
    return null;
  }

  @Override
  public List<Piece> findAllPieces() throws RepositoryException {
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      conn = jdbcConnectionFactory.createConnection();
      stmt = conn.createStatement();
      String sql = getFindAllPiecesQuery();
      rs = stmt.executeQuery(sql);
      return mapPieceResultRows(rs);

    } catch (SQLException e) {
      throw new RepositoryException(e);
      
    } finally {
      try {
        if (rs != null) {
          rs.close();
        }
        if (stmt != null) {
          stmt.close();
        }
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException e) {
        throw new RepositoryException(e);
      }  
    }
  }

  private String getFindAllPiecesQuery() {
    return "SELECT p.id, p.title, c.first_name, c.last_name FROM piece p"
      + " LEFT OUTER JOIN composer c ON p.composer_id = c.id";
  }
  
  private List<Piece> mapPieceResultRows(ResultSet rs) throws SQLException {
    List<Piece> pieces = new ArrayList<Piece>();
    
    while (rs.next()) {
      
      Piece piece = new Piece();
      piece.setId(rs.getInt("id"));
      piece.setTitle(rs.getString("title"));
      
      Composer composer = new Composer();
      composer.setFirstName(rs.getString("first_name"));
      composer.setLastName(rs.getString("last_name"));
      
      piece.setComposer(composer);      
      pieces.add(piece);
    }
    return pieces;
  }
  
  JdbcConnectionFactory getJdbcConnectionFactory() {
    return jdbcConnectionFactory;
  }  
}