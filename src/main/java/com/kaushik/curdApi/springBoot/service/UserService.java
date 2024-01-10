package com.kaushik.curdApi.springBoot.service;

import com.kaushik.curdApi.springBoot.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    String deleteUser(Long id);

    Optional<User> getUserById(Long id);

    User updateUser(Long id, User updatedUser);

//    User updateBook(Long id, User user);
}
