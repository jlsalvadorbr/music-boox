package musicboox.service;

import java.io.File;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import musicboox.model.JFuguePiecePlayerImpl;
import musicboox.model.Score;
import musicboxx.util.FileUtils;

import org.jfugue.Player;

@Path("/player")
public class PlayerService {  

  @Context 
  private HttpServletResponse response;
  private StringCacheManager cacheManager = StringCacheManager.getInstance();

  @GET 
  @Path("{guid}")
  @Produces("text/plain; charset=x-user-defined")
  //Produces required to be parsed as binary string, 
  //since AngularJs does not provide overrideMimeType() function
  public byte[] playGuid(@PathParam("guid") String guid) throws Exception {

    //response.setHeader("Access-Control-Allow-Origin", "*");

    JFuguePiecePlayerImpl jfugueMusicPlayerImpl = new JFuguePiecePlayerImpl(new Player());
    String score = cacheManager.getAndRemove(guid);
    File midi = jfugueMusicPlayerImpl.getMidi(score);
    return FileUtils.getByteArray(midi);
  }

  @POST 
  @Path("score")
  @Produces("text/plain; charset=x-user-defined") 
  //Produces required to be parsed as binary string, 
  //since AngularJs does not provide overrideMimeType() function
  public byte[] playScore(Score score) throws Exception {

    //response.setHeader("Access-Control-Allow-Origin", "*");

    JFuguePiecePlayerImpl jfugueMusicPlayerImpl = new JFuguePiecePlayerImpl(new Player());
    File midi = jfugueMusicPlayerImpl.getMidi(score.getScore());
    return FileUtils.getByteArray(midi);
  }

  @GET 
  @Path("score/{score}")
  @Produces("text/plain; charset=x-user-defined") 
  //Produces required to be parsed as binary string, 
  //since AngularJs does not provide overrideMimeType() function
  public byte[] playScore(@PathParam("score") String score) throws Exception {

    //response.setHeader("Access-Control-Allow-Origin", "*");

    JFuguePiecePlayerImpl jfugueMusicPlayerImpl = new JFuguePiecePlayerImpl(new Player());
    File midi = jfugueMusicPlayerImpl.getMidi(score);
    return FileUtils.getByteArray(midi);
  }
}
