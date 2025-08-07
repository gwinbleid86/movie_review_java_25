package kg.attractor.movie_review_java_25.model;

import lombok.Data;

import java.util.List;

@Data
public class Movie {
    private int id;
    private String name;
    private int releaseYear;
    private String description;
    private Director director;
    private List<Cast> cast;

}
