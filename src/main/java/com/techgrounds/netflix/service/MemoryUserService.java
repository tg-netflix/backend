package com.techgrounds.netflix.service;

import com.techgrounds.netflix.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/*@Component
public class MemoryUserService implements UserService {
    private HashMap<String, User> Data = new HashMap<>();

    @Override
    public long newUser(String name) {
        var id = Data.size() + 1;
        Data.put(name, new User(id, name, new ArrayList<>()));
        return id;
    }


    public boolean setFavorite(String name, long movieId, boolean add) {
        if (!Data.containsKey(name)) {
            newUser(name);
        }
        var liked = Data.get(name).liked;
        if (add) liked.add(movieId);
        else liked.remove(movieId);
        return true;
    }

    @Override
    public ArrayList<Long> favorites(String name) {
        if (!Data.containsKey(name)) {
            newUser(name);
        }
        return Data.get(name).liked;
    }

    @Override
    public ArrayList<Long> suggestions(String name) {
        return null;
    }

    public ArrayList<User> All() {
        return (ArrayList<User>) Data.values().stream().toList();
    }
}*/
