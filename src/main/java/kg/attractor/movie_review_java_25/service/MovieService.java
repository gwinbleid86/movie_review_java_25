package kg.attractor.movie_review_java_25.service;

import kg.attractor.movie_review_java_25.dto.MovieDto;

import java.util.List;

public interface MovieService {

    List<MovieDto> getAllMovies();

    MovieDto getMovieById(long id);
}
