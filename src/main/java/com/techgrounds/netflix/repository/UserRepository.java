package com.techgrounds.netflix.repository;

import com.techgrounds.netflix.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
