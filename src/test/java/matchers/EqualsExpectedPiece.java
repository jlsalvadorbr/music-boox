package matchers;

import musicboox.model.Piece;

import org.hamcrest.*;

public class EqualsExpectedPiece extends TypeSafeMatcher<Piece> {
	
	private final Piece expectedPiece;
	
	private EqualsExpectedPiece(Piece expectedPiece) {
		this.expectedPiece = expectedPiece;
	}

	@Override
	protected boolean matchesSafely(Piece piece) {
		if (expectedPiece.getId() != piece.getId()) return false;
		if (objectsAreEqual(expectedPiece.getTitle(), piece.getTitle()) == false) return false;
		//if (objectsAreEqual(expectedPiece.getScore(), piece.getScore()) == false) return false;
		if (expectedPiece.getComposer() != null && piece.getComposer() == null) return false;
		if (expectedPiece.getComposer() == null && piece.getComposer() != null) return false;
		//if (expectedPiece.getComposer() != null && piece.getComposer() != null) {
			//if (expectedPiece.getComposer().getId() != piece.getComposer().getId()) return false;
		//}	
		return true;
	}
	
	private boolean objectsAreEqual(Object object1, Object object2) {
		return (object1 == null ? object2 == null :
			object1.equals(object2));
	}
	
	@Override
	public void describeTo(Description description) {
		description.appendText("Piece doesn't match expected value");
	}
	
	@Factory
	public static EqualsExpectedPiece equalsExpectedPiece(Piece expectedPiece) {
		return new EqualsExpectedPiece(expectedPiece);
	}	
}