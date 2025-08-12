package kg.attractor.movie_review_java_25.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_cast_member")
public class MovieCastMember {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MovieCastMemberCompositeId {
        @ManyToOne
        @JoinColumn(name = "movie_id")
        private Movie movie;
        @ManyToOne
        @JoinColumn(name = "cast_member_id")
        private Cast cast;

    }

    @EmbeddedId
    private MovieCastMemberCompositeId id;

    private String role;
}
