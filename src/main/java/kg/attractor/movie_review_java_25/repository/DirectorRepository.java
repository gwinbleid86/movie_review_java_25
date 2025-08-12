package kg.attractor.movie_review_java_25.repository;

import kg.attractor.movie_review_java_25.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
}
