package com.example.configs.repository;

import com.example.configs.objects.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
