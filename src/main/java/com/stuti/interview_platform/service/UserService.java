package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.User;
import com.stuti.interview_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User registerUser(User user) {
        return repository.save(user);
    }

    public User loginUser(
            String username,
            String password
    ) {
        User user =
repository
.findByUsername(username)
.orElseThrow(
        () -> new RuntimeException(
                "User not found"
        )
);

        if (user != null &&
                user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
