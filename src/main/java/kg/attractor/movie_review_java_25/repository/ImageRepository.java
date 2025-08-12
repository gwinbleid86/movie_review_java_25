package kg.attractor.movie_review_java_25.repository;

import kg.attractor.movie_review_java_25.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByMovie_Id(long movieId);
}
