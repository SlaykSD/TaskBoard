package ru.mephi.taskboard.service;

import org.springframework.stereotype.Service;
import ru.mephi.taskboard.models.User;
import ru.mephi.taskboard.repo.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User saveUser(User UserColumn) {
        return userRepository.save(UserColumn);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
