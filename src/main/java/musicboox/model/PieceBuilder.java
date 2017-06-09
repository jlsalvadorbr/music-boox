package musicboox.model;


public class PieceBuilder {

  private int id;
  private String title;
  private Composer composer;
  private String score;

  public PieceBuilder() {
  }

  public PieceBuilder withId(int id) {
    this.id = id;
    return this;
  }

  public PieceBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public PieceBuilder withComposer(Composer composer) {
    this.composer = composer;
    return this;
  }

  public PieceBuilder withScore(String score) {
    this.score = score;
    return this;
  }

  public Piece build() {
    Piece piece = new Piece();
    piece.setId(id);
    piece.setTitle(title);
    piece.setComposer(composer);
    piece.setScore(score);
    return piece;
  }
}