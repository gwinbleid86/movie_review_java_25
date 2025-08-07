package kg.attractor.movie_review_java_25.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DirectorDto {
    private long id;
    private String fullName;
}
