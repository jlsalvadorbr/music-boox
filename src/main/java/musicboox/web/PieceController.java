package musicboox.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musicboox.model.Piece;
import musicboox.repository.PieceRepository;
import musicboox.repository.RepositoryFactory;
import musicboox.repository.jdbc.JdbcConfiguration;
import musicboox.repository.jdbc.JdbcRepositoryFactory;

//@WebServlet(urlPatterns="/pieces/*", name="PieceController")
public class PieceController extends HttpServlet {

  private static final Pattern SHOW_PIECE_DETAIL_URL = Pattern.compile("/([0-9])+");
  private static final Pattern PLAY_PIECE_URL = Pattern.compile("/([0-9])+/play");

  private RepositoryFactory repositoryFactory;

  @Override
  public void init() throws ServletException {
    //Convenience way to initialize the repository factory, 
    //defined as instance variable to allow being mocked in testing code
    //Not required when using frameworks supporting proper Dependency Injection
    try {
      JdbcConfiguration jdbcConfiguration = 
          readJdbcConfiguration("db/hsqldb/jdbc-config.properties");
      repositoryFactory = JdbcRepositoryFactory.getInstance(jdbcConfiguration);
    } catch (IOException e) {
      throw new ServletException(e);
    }
  }

  private JdbcConfiguration readJdbcConfiguration(String jdbcConfigFile) throws IOException {
    Properties jdbcProperties = new Properties();
    InputStream is = this.getClass().getClassLoader().getResourceAsStream(jdbcConfigFile);
    try {
      jdbcProperties.load(is);
      return new JdbcConfiguration(jdbcProperties);
    } finally {
      if (is != null) {
        is.close();
      }
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    final String pathInfo = request.getPathInfo();

    if (pathInfo == null) {
      showPiecesList(request, response);
      return;
    }

    if (SHOW_PIECE_DETAIL_URL.matcher(pathInfo).matches()) {
      showPieceDetail(request, response);
      return;
    }

    throw new ServletException("Invalid URI");
  }

  private void showPiecesList(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PieceRepository pieceRepository = repositoryFactory.getPieceRepository();
    List<Piece> pieces = pieceRepository.findAllPieces();

    request.setAttribute("pieces", pieces);
    request.getRequestDispatcher("/WEB-INF/jsp/piecesList.jsp").forward(request,response);
  }

  private void showPieceDetail(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    request.getRequestDispatcher("/WEB-INF/jsp/pieceDetail.jsp").forward(request,response);
  }

  //Convenience method to inject a mocked repository factory for testing purposes
  //Not required when using frameworks supporting proper Dependency Injection
  void setRepositoryFactory(RepositoryFactory repositoryFactory) {
    this.repositoryFactory = repositoryFactory;
  }
}
