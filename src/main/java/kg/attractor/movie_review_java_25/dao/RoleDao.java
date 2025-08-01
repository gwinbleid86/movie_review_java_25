package kg.attractor.movie_review_java_25.dao;

import kg.attractor.movie_review_java_25.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RoleDao {
    private final JdbcTemplate jdbcTemplate;

    public Optional<Role> findByUserEmail(String email) {
        String sql = "select r.* from ROLES r, USER_TABLE ut " +
                "where ut.ROLE_ID = r.ID " +
                "and ut.EMAIL = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Role.class),
                                email
                        )
                )
        );
    }

    public Optional<Role> findByRoleName(String roleName) {
        String sql = "select * from ROLES " +
                "where ROLE_NAME = ?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Role.class),
                                roleName
                        )
                )
        );
    }
}
