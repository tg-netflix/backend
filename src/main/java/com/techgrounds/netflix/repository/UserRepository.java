package com.techgrounds.netflix.repository;

import com.techgrounds.netflix.entity.NetflixUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<NetflixUser, Long> {
    @Query(value = "SELECT * FROM NETFLIX_USER WHERE name =:userName", nativeQuery = true)
    List<NetflixUser> userByName(String userName);
}
