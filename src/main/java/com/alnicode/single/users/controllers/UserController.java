package com.alnicode.single.users.controllers;

import com.alnicode.single.users.models.UserModel;
import com.alnicode.single.users.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{age}")
    public Optional<List<UserModel>> getUsersByAge(@PathVariable("age") int age) {
        return userService.getUsersByAge(age);
    }

    @PostMapping("/save")
    public UserModel saveUser(@RequestBody UserModel user) {
        return userService.save(user);
    }

    @DeleteMapping("{userId}")
    public boolean deleteUser(@PathVariable("userId") long userId) {
        return userService.delete(userId);
    }

}
