package kg.attractor.movie_review_java_25.controller;

import jakarta.validation.Valid;
import kg.attractor.movie_review_java_25.dto.UserDto;
import kg.attractor.movie_review_java_25.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "auth/register";
    }

    @PostMapping("register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            userService.createUser(userDto);
            return "redirect:/";
        }
        model.addAttribute("userDto", userDto);
        return "auth/register";
    }
}
