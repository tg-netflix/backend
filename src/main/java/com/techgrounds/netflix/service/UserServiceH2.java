package com.techgrounds.netflix.service;

import java.util.ArrayList;
import java.util.stream.StreamSupport;

import com.techgrounds.netflix.entity.User;
//import com.techgrounds.netflix.repository.UserRepository;
import com.techgrounds.netflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceH2 implements UserService {
    @Autowired
    private UserRepository userRepository;
    private long id = 0;

    @Override
    public long newUser(String name) {
        userRepository.save(new User(id, name, new ArrayList<>()));
        return id++;
    }

    private User userWithName(String username) {
        return userWithName(username, false);
    }
    private User userWithName(String userName, boolean parallel) {
        var iter = userRepository.findAll().spliterator();
        var user = StreamSupport.stream(iter, parallel)
                .filter(x -> x.name == userName)
                .findFirst();
        return user.isPresent() ?
                user.get() : null;
    }

    @Override
    public boolean setFavorite(String userName, long movieId, boolean add) {
        var user = userWithName(userName);
        if (user != null) {
            var liked = user.liked;
            if (add) liked.add(movieId);
            else liked.remove(movieId);
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Long> favorites(String userName) {
        var user = userWithName(userName);
        if (user != null) {
            return user.liked;
        }
        return null;
    }
    @Override
    public ArrayList<Long> suggestions(String user) {
        return null;
    }
}
