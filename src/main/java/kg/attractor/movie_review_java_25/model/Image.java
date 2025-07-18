package kg.attractor.movie_review_java_25.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
    private Long id;
    private String fileName;
    private Long movieId;
}
