package com.techgrounds.netflix.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.techgrounds.netflix.entity.User;
//import com.techgrounds.netflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Service
public class UserServiceH2 implements UserService {
    @Autowired
    private UserRepository userRepository;
    private long id = 0;

    private static String defaultName = "Bob";
    private static LocalDate defaultDate = LocalDate.of(1969, 4, 20);

    @Override
    public long newUser() {
        userRepository.save(new User(id, defaultName, new ArrayList<>(), defaultDate));
        return id++;
    }
    @Override
    public long newUser(String name, LocalDate date) {
        userRepository.save(new User(id, name, new ArrayList<>(), date));
        return id++;
    }

    @Override
    public boolean setDate(long id, LocalDate date) {
        try {
            userRepository.findById(id).get().setDate(date);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setName(long id, String name) {
        try {
            userRepository.findById(id).get().setName(name);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean setFavorite(long id, long movieId, boolean add) {
        try {
            var liked = userRepository.findById(id).get().Liked;
            if (add) liked.add(movieId);
            else liked.remove(movieId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<Long> getFavorites(long id) {
        try {
            return userRepository.findById(id).get().Liked;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ArrayList<Long> getSuggestions(long id) {
        return null;
    }
}*/
