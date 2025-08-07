package kg.attractor.movie_review_java_25.dao;

import kg.attractor.movie_review_java_25.model.Cast;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CastMemberDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Cast> findByMovieId(int movieId) {
        String sql = "select * from CAST_MEMBER cm, MOVIE_CAST_MEMBER mcm " +
                "where cm.ID = mcm.CAST_MEMBER_ID " +
                "and mcm.MOVIE_ID = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cast.class), movieId);
    }
}
