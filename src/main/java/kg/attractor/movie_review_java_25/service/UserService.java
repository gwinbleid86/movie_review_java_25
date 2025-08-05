package kg.attractor.movie_review_java_25.service;

import kg.attractor.movie_review_java_25.dto.UserDto;
import kg.attractor.movie_review_java_25.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    User findByUsername(String username);

    User createUser(UserDto user);

    User save(User user);

    User create(User user);

    UserDetailsService userDetailsService();

    User getCurrentUser();
}
