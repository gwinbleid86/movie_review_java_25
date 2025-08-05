package kg.attractor.movie_review_java_25.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kg.attractor.movie_review_java_25.dto.JwtAuthenticationResponse;
import kg.attractor.movie_review_java_25.dto.SignInRequest;
import kg.attractor.movie_review_java_25.dto.SignUpRequest;
import kg.attractor.movie_review_java_25.dto.UserDto;
import kg.attractor.movie_review_java_25.model.User;
import kg.attractor.movie_review_java_25.service.UserService;
import kg.attractor.movie_review_java_25.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @GetMapping("username/{username}")
    public User getUsersByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid UserDto user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request) {
        return authenticationService.signIn(request);
    }

}
