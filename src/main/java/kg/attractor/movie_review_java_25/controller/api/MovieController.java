package kg.attractor.movie_review_java_25.controller.api;

import kg.attractor.movie_review_java_25.dto.MovieDto;
import kg.attractor.movie_review_java_25.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("restMovies")
@RequestMapping("api/movies") // movies/
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

//    @GetMapping // movies/
//    public List<Movie> getAllMovies() {
//        return movieService.getAllMovies();
//    }

    @GetMapping("{movieId}") // movies/1
    public MovieDto getMovie(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

//    @PostMapping
//    public HttpStatus addMovie(@RequestBody MovieDto movieDto) {
//        movieService.createMovie(movieDto);
//        return HttpStatus.CREATED;
//    }


}
