package model;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import musicboox.model.JFuguePiecePlayerImpl;
import org.jfugue.Player;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class JFuguePiecePlayerImplTest {
  
  private JFuguePiecePlayerImpl jfuguePiecePlayerImpl;
  @Mock private Player player;
  
  @Before
  public void setUp() throws Exception {
    initMocks(this);
    jfuguePiecePlayerImpl = new JFuguePiecePlayerImpl(player);
  }
  
  @Test
  public void testPlay() {
    
    //When
    jfuguePiecePlayerImpl.play("C D E F G A B");
    
    //Then
    verify(player).play("C D E F G A B");
  }
}
