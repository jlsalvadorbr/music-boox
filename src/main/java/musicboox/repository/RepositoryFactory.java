package musicboox.repository;

public abstract class RepositoryFactory {

  public abstract ComposerRepository getComposerRepository();

  public abstract PieceRepository getPieceRepository();
}