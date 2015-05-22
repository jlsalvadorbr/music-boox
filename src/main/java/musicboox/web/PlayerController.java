package musicboox.web;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.jfugue.Player;

import musicboox.model.*;
import musicboox.repository.*;
import musicboox.repository.jdbc.*;
import musicboxx.util.FileUtils;

@WebServlet(urlPatterns="/player/*", name="PlayerController")
public class PlayerController extends HttpServlet {
	
	private Pattern DEMO = Pattern.compile("/demo");
	private Pattern PLAY = Pattern.compile("/demo/play");
	
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
		
		JFuguePiecePlayerImpl jFugueMusicPlayerImpl = new JFuguePiecePlayerImpl(new Player());
		File midi = jFugueMusicPlayerImpl.getMidi("C D E F G A B");
		
		response.setContentType("audio/midi");
		ServletOutputStream out= response.getOutputStream();
		out.write(FileUtils.getByteArray(midi));
		out.close();
	}
}
