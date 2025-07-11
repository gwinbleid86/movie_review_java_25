package kg.attractor.movie_review_java_25.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Movie {
    private int id;
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast;

    @Override
    public String toString() {
        return String.format("Фильм: <<%s>>,\nГод выпуска: %s,\nОписание: %s,\n%s,\nАктеры: %s", name, year, description, director, cast);
    }
}
