package applet;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class MidiPlayerApplet extends Applet {

  private AudioClip audioClip; 

  /*
  public void init() {
  }
  */

  public void play(String score) throws Exception {
    audioClip = getAudioClip(getUrl(score));
    audioClip.play();
  }

  private URL getUrl(String score) throws MalformedURLException {
    URL codeBaseUrl = getCodeBase();
    String protocol = codeBaseUrl.getProtocol();
    String host = codeBaseUrl.getHost();
    int port = codeBaseUrl.getPort();
    URL url = new URL(protocol, host, port, "/music-boox/service/player/score/" + score);
    return url;
  }

  public void stop() {
    audioClip.stop();
  }
}