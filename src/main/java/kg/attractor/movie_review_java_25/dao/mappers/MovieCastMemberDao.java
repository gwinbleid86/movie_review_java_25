package kg.attractor.movie_review_java_25.dao.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieCastMemberDao {
    private final JdbcTemplate jdbcTemplate;

    public String getRoleByMovieIdAndCastMemberId(long movieId, long castMemberId) {
        String sql = "select ROLE from MOVIE_CAST_MEMBER " +
                "where MOVIE_ID = ? " +
                "and CAST_MEMBER_ID = ?";
        return jdbcTemplate.queryForObject(sql, String.class, movieId, castMemberId);
    }
}
