package musicboox.model;

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
}
