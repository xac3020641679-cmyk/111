package com.cafeteria.service;

import com.cafeteria.model.User;
import com.cafeteria.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        if (user.getRole() == User.Role.MANAGER && userRepository.existsByRole(User.Role.MANAGER)) {
            throw new IllegalStateException("A manager already exists");
        }
        if (user.getRole() == User.Role.KITCHEN_CHIEF && userRepository.existsByRole(User.Role.KITCHEN_CHIEF)) {
            throw new IllegalStateException("A kitchen chief already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
