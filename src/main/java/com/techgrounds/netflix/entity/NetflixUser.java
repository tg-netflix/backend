package com.techgrounds.netflix.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table
public class NetflixUser {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column
    private String name;
    @Column
    private ArrayList<Long> liked;
}
