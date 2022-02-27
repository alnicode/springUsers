package com.alnicode.single.users.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.alnicode.single.users.models.UserModel;
import com.alnicode.single.users.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserModel save(UserModel user) {
        return userRepository.save(user);
    }

    public ArrayList<UserModel> getAll() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public Optional<UserModel> getUser(long userId) {
        return userRepository.findById(userId);
    }

    public boolean delete(Long userId) {
        return getUser(userId).map(user -> {
            userRepository.deleteById(userId);
            return true;
        }).orElse(false);
    }

    public Optional<List<UserModel>> getUsersByAge(int age) {
        return userRepository.findByAge(age);
    }
}