package com.techgrounds.netflix.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String name;
    private ArrayList<Long> liked;
}
