package com.kaushik.curdApi.springBoot.service;

import com.kaushik.curdApi.springBoot.entity.User;
import com.kaushik.curdApi.springBoot.exception.UserNotFoundException;
import com.kaushik.curdApi.springBoot.repository.UserRepository;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteAllById(Collections.singleton(id));
        return "user deleted!";
    }

    @Override
    public Optional<User> getUserById(Long id) {
       Optional <User> findingUser= userRepository.findById(id);
       if(findingUser.isPresent()){
           return findingUser;
       }else {
           throw new UserNotFoundException("User not found with id: +"+id);
       }
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setUserEmail(updatedUser.getUserEmail());
            existingUser.setAddress(updatedUser.getAddress());
            // Update other fields as needed

            return userRepository.save(existingUser);
        } else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }
    }

//    @Override
//    public User updateBook(Long id, User user) {
//        User existingBook = userRepository.findById(id).orElse(null);
//
//        if (existingBook != null) {
//                        BeanUtils.copyProperties(user, existingBook, "UserId");
//                        return userRepository.save(existingBook);
//        } else {
//            return null;
//        }
//    }

