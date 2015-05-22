package musicboox.model;

import java.io.File;
import java.io.IOException;

import org.jfugue.Player;

public class JFuguePiecePlayerImpl implements PiecePlayer {
	
	private Player player;

	public JFuguePiecePlayerImpl(Player player) {
		this.player = player;
	}
	
	@Override
	public void play(String score) {
		player.play(score);
	}
	
	public File getMidi(String score) throws IOException
	{
		File tempFile = File.createTempFile("tempFile", ".tmp");
		player.saveMidi(score, tempFile);
		return tempFile;
	}
}