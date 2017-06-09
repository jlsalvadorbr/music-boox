package musicboox.web;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musicboox.model.JFuguePiecePlayerImpl;
import musicboxx.util.FileUtils;

import org.jfugue.Player;

//@WebServlet(urlPatterns="/player/*", name="PlayerController")
public class PlayerController extends HttpServlet {
  
  private static final Pattern DEMO = Pattern.compile("/demo");
  private static final Pattern PLAY = Pattern.compile("/demo/play");
  
  @Override
  public void init() throws ServletException {
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    final String pathInfo = request.getPathInfo();
    
    if (DEMO.matcher(pathInfo).matches()) {
      demo(request, response);
      return;
    }
    
    if (PLAY.matcher(pathInfo).matches()) {
      play(request, response);
      return;
    }
    
    throw new ServletException("Invalid URI");
  }

  
  private void demo(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.getRequestDispatcher("/demo.jsp").forward(request,response);
  }
  
  private void play(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    JFuguePiecePlayerImpl jfuguePiecePlayerImpl = new JFuguePiecePlayerImpl(new Player());
    File midi = jfuguePiecePlayerImpl.getMidi("C D E F G A B");
    
    response.setContentType("audio/midi");
    ServletOutputStream out = response.getOutputStream();
    out.write(FileUtils.getByteArray(midi));
    out.close();
  }
}
