package kg.attractor.movie_review_java_25.service;

import kg.attractor.movie_review_java_25.dto.MovieDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface MovieService {

    default Sort getSortMethod(String sortValue) {
        return switch (sortValue) {
            case "year" -> Sort.by("releaseYear");
            case "rating" -> Sort.by("rating");
            default -> Sort.by("name");
        };
    }

    List<MovieDto> getAllMovies();

//    List<MovieDto> getAllSortedMovies(String sortedValue);

    List<MovieDto> getAllSortedAndPagedMovies(Pageable pageable);

    MovieDto getMovieById(long id);
}
