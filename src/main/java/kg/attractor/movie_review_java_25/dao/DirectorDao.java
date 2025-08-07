package kg.attractor.movie_review_java_25.dao;

import kg.attractor.movie_review_java_25.model.Director;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DirectorDao {
    private final JdbcTemplate jdbcTemplate;

    public Optional<Director> findById(long id) {
        String sql = "select * from director where id = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Director.class),
                                id
                        )
                )
        );
    }

    public Director findByMovieId(long movieId) {
        String sql = "select * from DIRECTOR d, MOVIE m " +
                "where d.ID = m.DIRECTOR_ID " +
                "and m.ID = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Director.class), movieId);
    }
}
