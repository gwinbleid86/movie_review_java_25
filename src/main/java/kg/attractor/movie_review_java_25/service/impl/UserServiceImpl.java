package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dao.UserDao;
import kg.attractor.movie_review_java_25.exceptions.UserNotFoundException;
import kg.attractor.movie_review_java_25.model.User;
import kg.attractor.movie_review_java_25.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findByUsername(String username) {
        return userDao.getByUsername(username);
    }

    @Override
    public User createUser(User user) {
        int newUserId = userDao.addUser(user);
        return getUserById(newUserId);
    }
}
