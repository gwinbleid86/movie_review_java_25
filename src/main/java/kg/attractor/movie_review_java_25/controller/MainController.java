package kg.attractor.movie_review_java_25.controller;

import kg.attractor.movie_review_java_25.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping
    public String index(Model model, Authentication authentication) {
        if (authentication != null) {
            model.addAttribute("authorities", authentication.getAuthorities());
        }
        model.addAllAttributes(mainService.getIndex());
        return "index";
    }
}
