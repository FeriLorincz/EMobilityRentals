package com.appiqus.emobilityrentals.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationResponse {

    private Integer id;
    private String address;

    public LocationResponse(Integer id, String address) {
        this.id = id;
        this.address = address;
    }

    // Constructor ce accepta id, tara, oras, strada, numar:
    public LocationResponse(Integer id, String country, String city, String street, Integer number){
        this.id = id;
        this.address = country + ", " + city + ", " + street + ", " + number;
    }

    //constructorul gol
    public LocationResponse(){}
}
