package fixtures;

import java.util.Date;

import musicboox.model.*;

public class ComposerFixtures {
	
	public static final Composer MOZART = new ComposerBuilder()
		.withId(1)
		.withFirstName("Wolfgang Amadeus").withLastName("Mozart")
		.withNationality("Austrian").withBirthDate(new Date(1756, 12, 5))
		.build();
	
	public static final Composer BEETHOVEN = new ComposerBuilder()
		.withId(2)
		.withFirstName("Ludwig van").withLastName("Beethoven")
		.withNationality("German").withBirthDate(new Date(1770, 12, 16))
		.build();
}