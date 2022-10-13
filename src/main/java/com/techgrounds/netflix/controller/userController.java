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

    @GetMapping("/liked")
    public ResponseEntity getLiked(@RequestParam long user) {
        return new ResponseEntity(userService.getFavorites(user), HttpStatus.OK);
    }

    @PutMapping("/liked")
    public ResponseEntity setFavorite(@RequestParam long id, @RequestParam long m, @RequestParam boolean liked) {
        userService.setFavorite(id, m, liked);
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @GetMapping("/suggestions")
    public ResponseEntity suggestions(@RequestParam long user) {
        return new ResponseEntity(
                userService.getSuggestions(user),
                HttpStatus.OK
        );
    }
}
