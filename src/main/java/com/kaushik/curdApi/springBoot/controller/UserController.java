package com.kaushik.curdApi.springBoot.controller;

import com.kaushik.curdApi.springBoot.entity.User;
import com.kaushik.curdApi.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/allUser")
    public List<User>getAllUser(){
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUSer(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getUser/{id}")
    public Optional<User>getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/updateUser/{id}")

//    public ResponseEntity<User> updateBook(@PathVariable("id") Long id, @RequestBody User user) {
//        User updated = userService.updateBook(id, user);
//
//        if (updated != null) {
//            return ResponseEntity.ok().body(updated);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    public User updateUser(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }


}
