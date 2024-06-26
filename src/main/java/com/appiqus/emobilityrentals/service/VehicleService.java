package com.appiqus.emobilityrentals.service;

import com.appiqus.emobilityrentals.dto.VehicleDto;
import com.appiqus.emobilityrentals.entity.Location;
import com.appiqus.emobilityrentals.entity.Vehicle;
import com.appiqus.emobilityrentals.repository.LocationRepository;
import com.appiqus.emobilityrentals.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, LocationRepository locationRepository) {
        this.vehicleRepository = vehicleRepository;
        this.locationRepository = locationRepository;
    }


    public Vehicle addVehicleToLocation(Integer locationId, VehicleDto vehicleDto) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(()-> new EntityNotFoundException("Location with id " + locationId + " not found"));

        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDto.getName());
        vehicle.setWheelsNumber(vehicleDto.getWheelsNumber());
        vehicle.setVehicleStatus(vehicleDto.getVehicleStatus());
        vehicle.setAutonomy(vehicleDto.getAutonomy());
        vehicle.setMaxSpeed(vehicleDto.getMaxSpeed());
        vehicle.setMaxPower(vehicleDto.getMaxPower());
        vehicle.setMaxWeight(vehicleDto.getMaxWeight());
        vehicle.setChargingTime(vehicleDto.getChargingTime());
        vehicle.setPrice(vehicleDto.getPrice());

        vehicle.addVehicleToLocation(location);

        return vehicleRepository.save(vehicle);

    }




}
