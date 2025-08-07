package kg.attractor.movie_review_java_25.controller;

import kg.attractor.movie_review_java_25.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
