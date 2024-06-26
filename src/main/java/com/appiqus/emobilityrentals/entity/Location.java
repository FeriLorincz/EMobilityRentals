package com.appiqus.emobilityrentals.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;
    private String city;
    private String street;
    private Integer number;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Vehicle> vehicle = new ArrayList<>();

}
