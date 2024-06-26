package com.appiqus.emobilityrentals.controller;

import com.appiqus.emobilityrentals.dto.LocationDto;
import com.appiqus.emobilityrentals.dto.LocationResponse;
import com.appiqus.emobilityrentals.entity.Location;
import com.appiqus.emobilityrentals.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "/add")
    public LocationResponse addLocation(@RequestBody LocationDto locationDto) {

        Location location = locationService.addLocation(locationDto);

        LocationResponse locationResponse = new LocationResponse();

        locationResponse.setId(location.getId());
        locationResponse.setAddress(location.getCountry() + " " + location.getCity() + " " + location.getStreet() + " " + location.getNumber());

        return locationResponse;
    }

    @PutMapping(path = "/update/{id}")
    public LocationResponse updateLocation(@PathVariable("id") Integer locationId, @RequestBody LocationDto locationDto) {
        Location location = locationService.updateLocation(locationId, locationDto);
        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setId(location.getId());
        locationResponse.setAddress(location.getCountry() + " " + location.getCity() + " " + location.getStreet() + " " + location.getNumber());

        return locationResponse;
    }

    @GetMapping(path = "/getLocationById/{id}")
    public ResponseEntity<Object> getLocationById(@PathVariable("id") Integer id) {

        Location location = locationService.getLocationById(id);

        LocationResponse locationResponse = new LocationResponse(
                location.getId(),
                location.getCountry(),
                location.getCity(),
                location.getStreet(),
                location.getNumber()
        );
        return ResponseEntity.ok(locationResponse);
    }

    @GetMapping(path = "/getAllLocations")
    public List<LocationResponse> getAllLocations() {
        List<Location> locationList = locationService.getAllLocations();
        List<LocationResponse> locationResponseList = new ArrayList<>();
        locationList.forEach(location -> {
            LocationResponse locationResponse = new LocationResponse();
            locationResponse.setId(location.getId());
            locationResponse.setAddress(location.getCountry() + ", " + location.getCity() + ", " + location.getStreet() + ", " + location.getNumber());
            locationResponseList.add(locationResponse);

        });
        return locationResponseList;
    }

}
