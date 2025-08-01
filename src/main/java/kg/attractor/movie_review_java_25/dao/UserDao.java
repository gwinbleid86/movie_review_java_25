package kg.attractor.movie_review_java_25.dao;

import kg.attractor.movie_review_java_25.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();

    public List<User> getAllUsers() {
        String sql = "select * from USER_TABLE";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public Optional<User> getByUsername(String username) {
        String sql = "select * from USER_TABLE\n" +
                "where EMAIL ilike :username;";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        namedParameterJdbcTemplate.query(
                                sql,
                                new MapSqlParameterSource()
                                        .addValue("username", "%" + username + "%"),
                                new BeanPropertyRowMapper<>(User.class)
                        )
                )
        );
    }

    public int addUser(User user) {
        String sql = "insert into USER_TABLE (EMAIL, PASSWORD) values (?, ?);";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    public boolean existsByUsername(String username) {
        String sql = "select count(*) from USER_TABLE " +
                "where EMAIL = ?";
        var result = jdbcTemplate.queryForObject(sql, Integer.class, username);
        return result != null && result > 0;
    }
}
