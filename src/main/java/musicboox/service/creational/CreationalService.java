package musicboox.service.creational;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import musicboox.model.JFuguePiecePlayerImpl;
import musicboox.model.Order;
import musicboox.model.Response;
import musicboox.model.Score;
import musicboox.service.StringCacheManager;
import musicboxx.util.FileUtils;

import org.jfugue.Player;

@Path("/creational")
public class CreationalService {  

  private StringCacheManager cacheManager = StringCacheManager.getInstance();

  @POST
  public Response create(Order order) throws Exception {
    String scoreGuid = UUID.randomUUID().toString();
    cacheManager.put(scoreGuid, order.getScore());

    Response response = new Response();
    response.setStatus(0);
    response.setScoreGuid(scoreGuid);

    return response;
  }
}
