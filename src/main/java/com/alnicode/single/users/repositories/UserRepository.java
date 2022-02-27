package com.alnicode.single.users.repositories;

import java.util.Optional;

import com.alnicode.single.users.models.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserModel, Long> {
    Optional<List<UserModel>> findByAge(int age);
}
