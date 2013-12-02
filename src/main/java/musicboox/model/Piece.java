package musicboox.model;


public class Piece {

	private int id;
	private String title;
	private Composer composer;
	private String score;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Composer getComposer() {
		return composer;
	}
	public void setComposer(Composer composer) {
		this.composer = composer;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}