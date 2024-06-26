package com.appiqus.emobilityrentals.controller;


import com.appiqus.emobilityrentals.dto.VehicleDto;
import com.appiqus.emobilityrentals.dto.VehicleResponse;
import com.appiqus.emobilityrentals.entity.Vehicle;
import com.appiqus.emobilityrentals.repository.VehicleRepository;
import com.appiqus.emobilityrentals.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(path = "/add/{LocationId}")
    public VehicleResponse addVehicleToLocation(@PathVariable("LocationId") Integer locationId, @RequestBody VehicleDto vehicleDto){

       Vehicle vehicle = vehicleService.addVehicleToLocation(locationId, vehicleDto);

       VehicleResponse vehicleResponse = new VehicleResponse(
               vehicle.getId(),
               vehicle.getName(),
               vehicle.getWheelsNumber(),
               vehicle.getVehicleStatus(),
               vehicle.getAutonomy(),
               vehicle.getMaxSpeed(),
               vehicle.getMaxPower(),
               vehicle.getMaxWeight(),
               vehicle.getChargingTime(),
               vehicle.getPrice(),
               vehicle.getLocation().getId());

               return vehicleResponse;
    }







}
