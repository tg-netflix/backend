package com.techgrounds.netflix.service;

import com.techgrounds.netflix.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    // new create user
    long newUser(String name);
    // sets the favorite
    boolean setFavorite(String name, long movieId, boolean add);
    // get favorites
    ArrayList<Long> favorites(String name);
    // get suggested movies
    ArrayList<Long> suggestions(String name);

}
