package kg.attractor.movie_review_java_25.service;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import kg.attractor.movie_review_java_25.dto.UserDto;
import kg.attractor.movie_review_java_25.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsers();

    User getUserById(String id);

    void createUser(UserDto user);

    User getByResetPasswordToken(String token);

    void updatePassword(User user, String newPasswd);

    void makeResetPasswordLink(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException;

    void processOAuthPostLogin(String username);
}
