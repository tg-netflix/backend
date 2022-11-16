package com.techgrounds.netflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import com.techgrounds.netflix.entity.NetflixUser;
//import com.techgrounds.netflix.repository.UserRepository;
import com.techgrounds.netflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class UserServiceH2 {
    @Autowired
    private UserRepository userRepository;

    public NetflixUser newUser(String name) {
        return userRepository.save(
            new NetflixUser()
                .setName(name)
                .setLiked(new ArrayList<>())
        );
    }

    public boolean setFavorite(String userName, long movieId, boolean add) {
        var users = userRepository.userByName(userName);
        var user = users.size() > 0 ?
                users.get(0) : newUser(userName);

        var liked = user.getLiked();
        if (add) liked.add(movieId);
        else liked.remove(movieId);
        userRepository.save(user);
        return true;
    }

    public ArrayList<Long> favorites(String userName) {
        var users = userRepository.userByName(userName);
        var user = users.size() >= 1 ?
                users.get(0) : newUser(userName);
        return user.getLiked();
    }

    public ArrayList<Long> suggestions(String user) {
        return null; //TODO create algorithm for this
    }
}
