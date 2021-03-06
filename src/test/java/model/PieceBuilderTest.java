package model;

import static org.junit.Assert.assertEquals;

import fixtures.ComposerFixtures;
import musicboox.model.Piece;
import musicboox.model.PieceBuilder;

import org.junit.Test;

public class PieceBuilderTest {

  @Test
  public void testBuild() {

    //Given
    PieceBuilder pieceBuilder = new PieceBuilder();

    //When
    pieceBuilder.withId(9);
    pieceBuilder.withTitle("title");
    pieceBuilder.withComposer(ComposerFixtures.MOZART);
    pieceBuilder.withScore("C D E F G A B");
    Piece piece = pieceBuilder.build();

    //Then
    assertEquals(9, piece.getId());
    assertEquals("title", piece.getTitle());
    assertEquals(ComposerFixtures.MOZART, piece.getComposer());
    assertEquals("C D E F G A B", piece.getScore());
  }
}
