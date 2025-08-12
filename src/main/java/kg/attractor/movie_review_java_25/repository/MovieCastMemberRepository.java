package kg.attractor.movie_review_java_25.repository;

import kg.attractor.movie_review_java_25.model.MovieCastMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCastMemberRepository extends JpaRepository<MovieCastMember, MovieCastMember.MovieCastMemberCompositeId> {
}
