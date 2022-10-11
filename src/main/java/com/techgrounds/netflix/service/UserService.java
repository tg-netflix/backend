package com.techgrounds.netflix.service;

import com.techgrounds.netflix.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;

public interface UserService {
    long newUser();
    long newUser(String name, LocalDate date);
    boolean setDate(long id, LocalDate date);
    boolean setName(long id, String name);
    boolean setFavorite(long id, long movieId, boolean add);

    ArrayList<Long> getFavorites(long id);
    ArrayList<Long> getSuggestions(long id);
}
