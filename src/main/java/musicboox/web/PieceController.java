package musicboox.web;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import musicboox.model.Piece;
import musicboox.repository.*;
import musicboox.repository.jdbc.*;

@WebServlet(urlPatterns="/pieces/*", name="PieceController")
public class PieceController extends HttpServlet {
	
	private Pattern SHOW_PIECE_DETAIL_URL = Pattern.compile("/([0-9])+");
	private RepositoryFactory repositoryFactory;
	
	@Override
	public void init() throws ServletException {
		//Convenience way to initialize the repository factory, 
		//defined as instance variable to allow being mocked in testing code
		//Not required when using frameworks supporting proper Dependency Injection
		try {
			JdbcConfiguration jdbcConfiguration = readJdbcConfiguration("db/hsqldb/jdbc-config.properties");
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
			if (is != null) is.close();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String pathInfo = request.getPathInfo();
		
		if (pathInfo==null) {
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