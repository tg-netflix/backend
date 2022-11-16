package com.techgrounds.netflix.repository;

import com.techgrounds.netflix.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
