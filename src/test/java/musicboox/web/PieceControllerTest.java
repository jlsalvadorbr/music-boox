package musicboox.web;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musicboox.model.Piece;
import musicboox.repository.PieceRepository;
import musicboox.repository.RepositoryFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

@RunWith(JUnit4.class)
public class PieceControllerTest {

  @Mock private HttpServletRequest request;
  @Mock private HttpServletResponse response;
  @Mock private RequestDispatcher requestDispatcher;
  @Mock private RepositoryFactory repositoryFactory;
  @Mock private PieceRepository pieceRepository;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void init() {
    initMocks(this);
  }

  @Test
  public void testShowPiecesList() throws Exception {

    //Given
    PieceController pieceController = new PieceController();
    pieceController.setRepositoryFactory(repositoryFactory);
    when(request.getPathInfo()).thenReturn(null);
    when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    when(repositoryFactory.getPieceRepository()).thenReturn(pieceRepository);
    List<Piece> expectedPieces = new ArrayList<Piece>(); 
    when(pieceRepository.findAllPieces()).thenReturn(expectedPieces);

    //When
    pieceController.doGet(request, response);

    //Then
    verify(request).setAttribute("pieces", expectedPieces);
    verify(request).getRequestDispatcher("/WEB-INF/jsp/piecesList.jsp");
    verify(requestDispatcher).forward(request,response);
  }

  @Test
  public void testShowPieceDetail() throws Exception {

    //Given
    PieceController pieceController = new PieceController();
    pieceController.setRepositoryFactory(repositoryFactory);
    when(request.getPathInfo()).thenReturn("/1");
    when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

    //When
    pieceController.doGet(request, response);

    //Then
    verify(request).getRequestDispatcher("/WEB-INF/jsp/pieceDetail.jsp");
    verify(requestDispatcher).forward(request,response);
  }

  @Test
  public void testInvalidUri() throws Exception {

    //Given
    when(request.getPathInfo()).thenReturn("/x");

    //Then
    thrown.expect(ServletException.class);
    thrown.expectMessage("Invalid URI");

    //When
    PieceController pieceController = new PieceController();
    pieceController.doGet(request, response);
  }
}