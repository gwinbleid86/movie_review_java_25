package kg.attractor.movie_review_java_25.dto;

import kg.attractor.movie_review_java_25.model.Cast;
import kg.attractor.movie_review_java_25.model.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private String name;
    private Integer year;
    private String description;
    private Director director;
    private List<Cast> cast;
}
