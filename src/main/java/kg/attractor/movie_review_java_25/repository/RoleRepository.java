package kg.attractor.movie_review_java_25.repository;

import kg.attractor.movie_review_java_25.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
