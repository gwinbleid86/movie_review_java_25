package kg.attractor.movie_review_java_25.service.impl;

import kg.attractor.movie_review_java_25.dao.RoleDao;
import kg.attractor.movie_review_java_25.dao.UserDao;
import kg.attractor.movie_review_java_25.dto.UserDto;
import kg.attractor.movie_review_java_25.exceptions.RoleNotFoundException;
import kg.attractor.movie_review_java_25.exceptions.UserNotFoundException;
import kg.attractor.movie_review_java_25.model.User;
import kg.attractor.movie_review_java_25.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;
    private final PasswordEncoder encoder;

    @Override
    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    @Override
    public User findByUsername(String username) {
        var user = userDao.getByUsername(username)
                .orElseThrow(UserNotFoundException::new);
        var role = roleDao.findByUserEmail(user.getEmail())
                .orElseThrow(RoleNotFoundException::new);

        user.setRole(role);
        return user;
    }

    @Override
    public User createUser(UserDto user) {
//        int newUserId = userDao.addUser(user);
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        return newUser;
    }

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    @Override
    public User save(User user) {
        userDao.addUser(user);
        return findByUsername(user.getEmail());
    }

    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    @Override
    public User create(User user) {
        if (userDao.existsByUsername(user.getUsername())) {
            // Заменить на свои исключения
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        return save(user);
    }


    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    @Override
    public UserDetailsService userDetailsService() {
        return this::findByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    @Override
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return findByUsername(username);
    }


    /**
     * Выдача прав администратора текущему пользователю
     * <p>
     * Нужен для демонстрации
     */
    @Deprecated
    public void getAdmin() {
        var user = getCurrentUser();
        var role = roleDao.findByRoleName("ADMIN")
                .orElseThrow(RoleNotFoundException::new);
        user.setRole(role);
        save(user);
    }

}
