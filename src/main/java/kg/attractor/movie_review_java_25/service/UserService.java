package kg.attractor.movie_review_java_25.service;

import kg.attractor.movie_review_java_25.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(int id);

    List<User> findByUsername(String username);

    User createUser(User user);
}
