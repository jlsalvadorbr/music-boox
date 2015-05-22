package applet;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class MidiPlayerApplet extends Applet {
	
	private AudioClip audioClip; 
	
	/*
	public void init() {
	}
	*/
	
	public void play() throws Exception {
		audioClip = getAudioClip(getUrl());
		audioClip.play();
	}
	
	private URL getUrl() throws MalformedURLException {
		System.out.println(getCodeBase().getHost());
		URL codeBaseURL = getCodeBase();
		String protocol = codeBaseURL.getProtocol();
		String host = codeBaseURL.getHost();
		int port = codeBaseURL.getPort();
		URL url = new URL(protocol, host, port, "/music-boox/player/demo/play");
		System.out.println(url.toString());
		return url;
	}
	
	public void stop() {
		audioClip.stop();
	}
}