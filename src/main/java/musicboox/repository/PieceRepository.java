package musicboox.repository;

import java.util.List;

import musicboox.model.Piece;

public interface PieceRepository {

  public List<Piece> findAllPieces();
  
  public List<Piece> findPiecesByComposerId(int id);
}
