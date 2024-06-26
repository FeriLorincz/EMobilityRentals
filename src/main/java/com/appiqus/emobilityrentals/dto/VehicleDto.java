package com.appiqus.emobilityrentals.dto;

import com.appiqus.emobilityrentals.entity.Location;
import com.appiqus.emobilityrentals.entity.enums.VehicleStatus;
import com.appiqus.emobilityrentals.entity.enums.WheelsNumber;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleDto {

    private String name;

    private WheelsNumber wheelsNumber;
    private VehicleStatus vehicleStatus;

    private Double autonomy;
    private Double maxSpeed;
    private Double maxPower;
    private Double maxWeight;
    private Double chargingTime;
    private Double price;
    private Location locationId;
}
