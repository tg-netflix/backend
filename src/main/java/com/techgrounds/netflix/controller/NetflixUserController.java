package com.techgrounds.netflix.controller;


import com.techgrounds.netflix.service.UserServiceH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class NetflixUserController {
    @Autowired
    UserServiceH2 userService;

    @PostMapping("/new")
    public ResponseEntity newUser(@RequestParam String user) {
        return new ResponseEntity(userService.newUser(user), HttpStatus.OK);
    }

    @GetMapping("/liked")
    public ResponseEntity getLiked(@RequestParam String user) {
        return new ResponseEntity(userService.favorites(user), HttpStatus.OK);
    }

    @PutMapping("/liked")
    public ResponseEntity setFavorite(@RequestParam String user, @RequestParam long movieId, @RequestParam boolean liked) {
        userService.setFavorite(user, movieId, liked);
        return new ResponseEntity(true, HttpStatus.OK);
    }

    @GetMapping("/suggestions")
    public ResponseEntity suggestions(@RequestParam String user) {
        return new ResponseEntity(
            userService.suggestions(user),
            HttpStatus.OK
        );
    }
}