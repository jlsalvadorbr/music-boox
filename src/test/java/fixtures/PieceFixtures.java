package fixtures;

import musicboox.model.Piece;
import musicboox.model.PieceBuilder;

public class PieceFixtures {

  public static final Piece MAGIC_FLUTE = new PieceBuilder()
      .withId(1)
      .withTitle("The Magic Flute").withComposer(ComposerFixtures.MOZART)
      .withScore("C D E F G A B")
      .build();

  public static final Piece DON_GIOVANNI = new PieceBuilder()
      .withId(2)
      .withTitle("Don Giovanni").withComposer(ComposerFixtures.MOZART)
      .withScore("C D E F G A B")
      .build();

  public static final Piece MARRIAGE_FIGARO = new PieceBuilder()
      .withId(3)
      .withTitle("The Marriage of Figaro").withComposer(ComposerFixtures.MOZART)
      .withScore("C D E F G A B")
      .build();

  public static final Piece FUR_ELISE = new PieceBuilder()
      .withId(4)
      .withTitle("Fur Elise").withComposer(ComposerFixtures.BEETHOVEN)
      .withScore("C D E F G A B")
      .build();

  public static final Piece MOONLIGHT_SONATA = new PieceBuilder()
      .withId(5)
      .withTitle("Moonlight Sonata").withComposer(ComposerFixtures.BEETHOVEN)
      .withScore("C D E F G A B")
      .build();

  public static final Piece PATHETIQUE_SONATA = new PieceBuilder()
      .withId(6)
      .withTitle("Pathetique Sonata").withComposer(ComposerFixtures.BEETHOVEN)
      .withScore("C D E F G A B")
      .build();

  public static final Piece NINETH_SYMPHONY = new PieceBuilder()
      .withId(7)
      .withTitle("9th  Symphony").withComposer(ComposerFixtures.BEETHOVEN)
      .withScore("C D E F G A B")
      .build();
}