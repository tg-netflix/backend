package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.service.MemoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class userController {
    @Autowired
    MemoryUserService userService;

    @PostMapping("/new")
    public long newUser() {
        return userService.newUser();
    }

    @GetMapping("liked=${u}")
    public ResponseEntity getLiked(long user) {
        return new ResponseEntity(userService.getFavorites(user), HttpStatus.OK);
    }

    @PutMapping("liked=${u, id, liked}")
    public ResponseEntity setFavorite(long id, long m, boolean liked) {
        userService.setFavorite(id, m, liked);
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @GetMapping("suggestions=${u}")
    public ResponseEntity suggestions(long id) {
        return new ResponseEntity(
                userService.getSuggestions(id),
                HttpStatus.OK
        );
    }
}
