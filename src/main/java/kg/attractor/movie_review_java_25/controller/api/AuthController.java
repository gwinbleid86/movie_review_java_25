package kg.attractor.movie_review_java_25.controller.api;

import jakarta.validation.Valid;
import kg.attractor.movie_review_java_25.dto.UserDto;
import kg.attractor.movie_review_java_25.model.User;
import kg.attractor.movie_review_java_25.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("restAuth")
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void createUser(@RequestBody @Valid UserDto user) {
        userService.createUser(user);
    }
}
