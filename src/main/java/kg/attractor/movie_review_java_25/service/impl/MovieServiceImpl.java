package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dto.CastMemberDto;
import kg.attractor.movie_review_java_25.dto.DirectorDto;
import kg.attractor.movie_review_java_25.dto.MovieDto;
import kg.attractor.movie_review_java_25.exceptions.DirectorNotFoundException;
import kg.attractor.movie_review_java_25.exceptions.MovieNotFoundException;
import kg.attractor.movie_review_java_25.model.Director;
import kg.attractor.movie_review_java_25.model.Movie;
import kg.attractor.movie_review_java_25.repository.DirectorRepository;
import kg.attractor.movie_review_java_25.repository.MovieRepository;
import kg.attractor.movie_review_java_25.service.CastService;
import kg.attractor.movie_review_java_25.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final CastService castService;

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(e -> {
                    Director director = directorRepository.findById(e.getDirector().getId())
                            .orElseThrow(DirectorNotFoundException::new);
                    List<CastMemberDto> castList = e.getMovieCastMemberList().stream()
                            .map(c -> castService.getCastMember(c.getCast().getId(), e.getId()))
                            .toList();
                    return MovieDto.builder()
                            .id(e.getId())
                            .name(e.getName())
                            .year(e.getReleaseYear())
                            .description(e.getDescription())
                            .director(DirectorDto.builder()
                                    .id(director.getId())
                                    .fullName(director.getFullName())
                                    .build())
                            .cast(castList)
                            .build();
                })
                .toList();
    }

    @Override
    public MovieDto getMovieById(long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
        List<CastMemberDto> castList = movie.getMovieCastMemberList().stream()
                .map(c -> castService.getCastMember(c.getCast().getId(), movie.getId()))
                .toList();
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .year(movie.getReleaseYear())
                .description(movie.getDescription())
                .cast(castList)
                .build();
    }
}
