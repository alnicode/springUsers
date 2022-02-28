package com.alnicode.single.users.repositories;

import java.util.Optional;

import com.alnicode.single.users.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    Optional<List<UserModel>> findByAge(int age);
}
