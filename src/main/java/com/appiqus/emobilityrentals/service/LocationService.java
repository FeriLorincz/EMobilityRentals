package com.appiqus.emobilityrentals.service;

import com.appiqus.emobilityrentals.dto.LocationDto;
import com.appiqus.emobilityrentals.entity.Location;
import com.appiqus.emobilityrentals.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location addLocation(LocationDto locationDto) {
        Location location = new Location();

        location.setCountry(locationDto.getCountry());
        location.setCity(locationDto.getCity());
        location.setStreet(locationDto.getStreet());
        location.setNumber(locationDto.getNumber());

        Location savedLocation = locationRepository.save(location);
        return savedLocation;
    }


    public Location updateLocation(Integer locationId, LocationDto locationDto) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new jakarta.persistence.EntityNotFoundException("Location with id " +locationId +" not found"));

        location.setCountry(locationDto.getCountry());
        location.setCity(locationDto.getCity());
        location.setStreet(locationDto.getStreet());
        location.setNumber(locationDto.getNumber());

        return locationRepository.save(location);
    }

    public Location getLocationById(Integer id) {

        Location location = locationRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Location with id " + id + " not found"));
        return location;
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
     }

}
