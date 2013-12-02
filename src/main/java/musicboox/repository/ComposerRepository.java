package musicboox.repository;

import java.util.List;

import musicboox.model.Composer;

public interface ComposerRepository {
	
	public List<Composer> findComposers();
	

}
