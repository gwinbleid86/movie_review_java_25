package kg.attractor.movie_review_java_25.repository;

import kg.attractor.movie_review_java_25.model.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepository extends JpaRepository<Cast, Long> {

    //    @Query(
//            value = "select mcm.ROLE from CAST_MEMBER cm, MOVIE_CAST_MEMBER mcm " +
//                    "where cm.ID = mcm.CAST_MEMBER_ID " +
//                    "and mcm.MOVIE_ID = :movieId " +
//                    "and mcm.CAST_MEMBER_ID = :castId",
//            nativeQuery = true
//    )
    @Query(
            "select mcm.role from Cast c, MovieCastMember mcm " +
                    "where c.id = mcm.cast.id " +
                    "and mcm.movie.id = :movieId " +
                    "and mcm.cast.id = :castId"
    )
    String findRoleByCast(long movieId, long castId);
}
