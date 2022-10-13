package com.techgrounds.netflix.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long ID;

    public String name;

    public ArrayList<Long> liked;
    public LocalDate date;

    public User(long id, String name, ArrayList<Long> liked, LocalDate date) {
        ID = id;
        this.name = name;
        this.liked = liked;
        this.date = date;
    }
}
