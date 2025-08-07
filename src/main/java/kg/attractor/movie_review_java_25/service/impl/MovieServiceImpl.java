package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dao.CastMemberDao;
import kg.attractor.movie_review_java_25.dao.DirectorDao;
import kg.attractor.movie_review_java_25.dao.MovieDao;
import kg.attractor.movie_review_java_25.dao.mappers.MovieCastMemberDao;
import kg.attractor.movie_review_java_25.dto.CastMemberDto;
import kg.attractor.movie_review_java_25.dto.DirectorDto;
import kg.attractor.movie_review_java_25.dto.MovieDto;
import kg.attractor.movie_review_java_25.exceptions.MovieNotFoundException;
import kg.attractor.movie_review_java_25.model.Director;
import kg.attractor.movie_review_java_25.model.Movie;
import kg.attractor.movie_review_java_25.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieDao movieDao;
    private final DirectorDao directorDao;
    private final CastMemberDao castMemberDao;
    private final MovieCastMemberDao movieCastMemberDao;

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieDao.getAllMovies();
        return movies.stream()
                .map(e -> {
                    Director director = directorDao.findByMovieId(e.getId());
                    List<CastMemberDto> castList = castMemberDao.findByMovieId(e.getId()).stream()
                            .map(c -> CastMemberDto.builder()
                                    .id(c.getId())
                                    .fullName(c.getFullName())
                                    .role(movieCastMemberDao.getRoleByMovieIdAndCastMemberId(e.getId(), c.getId()))
                                    .build())
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
        Movie movie = movieDao.getMovieById(id)
                .orElseThrow(MovieNotFoundException::new);
        return MovieDto.builder()
                .id(movie.getId())
                .name(movie.getName())
                .year(movie.getReleaseYear())
                .description(movie.getDescription())
                .build();
    }
}
