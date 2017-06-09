package musicboox.web;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musicboox.repository.PieceRepository;
import musicboox.repository.RepositoryFactory;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

@RunWith(JUnit4.class)
public class PlayerControllerTest {

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
  public void testDemo() throws Exception {

    //Given
    PlayerController playerController = new PlayerController();
    when(request.getPathInfo()).thenReturn("/demo");
    when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

    //When
    playerController.doGet(request, response);

    //Then
    verify(request).getRequestDispatcher("/demo.jsp");
    verify(requestDispatcher).forward(request,response);
  }

  @Test
  @Ignore //TODO once midi generation evolves  
  public void testPlay() throws Exception {

    //Given
    PlayerController playerController = new PlayerController();
    when(request.getPathInfo()).thenReturn("/demo/play");
    when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);

    //When
    playerController.doGet(request, response);

    //Then
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