package com.techgrounds.netflix.entity;

import lombok.AllArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long ID;

    public String name;

    public ArrayList<Long> liked;
}
