package com.techgrounds.netflix.service;

import com.techgrounds.netflix.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class MemoryUserService implements UserService {
    private ArrayList<User> Data = new ArrayList<>();

    @Override
    public long newUser() {
        var id = Data.size() + 1;
        Data.add(new User(id, "Bob", new ArrayList<>(), LocalDate.of(1969, 4, 20)));
        return id;
    }

    @Override
    public long newUser(String name, LocalDate date) {
        var id = Data.size() + 1;
        Data.add(new User(id, name, new ArrayList<>(), date));
        return id;
    }

    public boolean setDate(long id, LocalDate date) {
        if (Data.size() < id) return false;
        Data.get((int)id).date = date;
        return true;
    }

    public boolean setName(long id, String name) {
        if (Data.size() < id) return false;
        Data.get((int)id).name = name;
        return true;
    }

    public boolean setFavorite(long id, long movieId, boolean add) {
        if (Data.size() < id) return false;
        var liked = Data.get((int)id).liked;
        if (add) liked.add(movieId);
        else liked.remove(movieId);
        return true;
    }

    @Override
    public ArrayList<Long> getFavorites(long id) {
        if (Data.size() < id) return null;
        return Data.get((int)id).liked;
    }

    @Override
    public ArrayList<Long> getSuggestions(long id) {
        return null;
    }
}
