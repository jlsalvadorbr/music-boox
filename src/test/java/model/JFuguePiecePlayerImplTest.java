package model;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import musicboox.model.JFuguePiecePlayerImpl;

import org.jfugue.Player;
import org.junit.*;
import org.mockito.Mock;

public class JFuguePiecePlayerImplTest {
	
	private JFuguePiecePlayerImpl jFuguePiecePlayerImpl;
	@Mock private Player player;
	
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		jFuguePiecePlayerImpl = new JFuguePiecePlayerImpl(player);
	}
	
	@Test
	public void testPlay() {
		
		//When
		jFuguePiecePlayerImpl.play("C D E F G A B");
		
		//Then
		verify(player).play("C D E F G A B");
	}
}
