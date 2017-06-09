package musicboox.repository.jdbc;

import java.util.List;

import musicboox.model.Composer;
import musicboox.repository.ComposerRepository;

public class JdbcComposerRepositoryImpl implements ComposerRepository {

  private JdbcConnectionFactory jdbcConnectionFactory;

  JdbcComposerRepositoryImpl(JdbcConnectionFactory jdbcConnectionFactory) {
    this.jdbcConnectionFactory = jdbcConnectionFactory;
  }

  @Override
  public List<Composer> findComposers() {
    return null;
  }

  JdbcConnectionFactory getJdbcConnectionFactory() {
    return jdbcConnectionFactory;
  }
}