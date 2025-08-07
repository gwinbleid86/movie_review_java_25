package kg.attractor.movie_review_java_25.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieCastMember {
    private Long movieId;
    private Long castMemberId;
    private String role;
}
