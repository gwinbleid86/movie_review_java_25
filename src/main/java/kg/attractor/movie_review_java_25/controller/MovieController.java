package kg.attractor.movie_review_java_25.controller;

import kg.attractor.movie_review_java_25.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public String getMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/movies";
    }

    @GetMapping("sorted")
    public String getSortedMovies(
            Pageable pageable,
            Model model
    ) {
        model.addAttribute("movies", movieService.getAllSortedAndPagedMovies(pageable));
        return "movies/movies";
    }

    @GetMapping("{movieId}")
    public String getMovie(@PathVariable int movieId, Model model) {
        model.addAttribute("movie", movieService.getMovieById(movieId));
        return "movies/view";
    }
}
