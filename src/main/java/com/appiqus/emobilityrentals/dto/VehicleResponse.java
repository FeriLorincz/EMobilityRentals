package com.appiqus.emobilityrentals.dto;

import com.appiqus.emobilityrentals.entity.Location;
import com.appiqus.emobilityrentals.entity.enums.VehicleStatus;
import com.appiqus.emobilityrentals.entity.enums.WheelsNumber;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class VehicleResponse {

    private Integer id;
    private String name;

    private WheelsNumber wheelsNumber;
    private VehicleStatus vehicleStatus;

    private Double autonomy;
    private Double maxSpeed;
    private Double maxPower;
    private Double maxWeight;
    private Double chargingTime;
    private Double price;
    private Integer locationId;

    public VehicleResponse(Integer id, String name, WheelsNumber wheelsNumber, VehicleStatus vehicleStatus,
                           Double autonomy, Double maxSpeed, Double maxPower, Double maxWeight, Double chargingTime,
                           Double price, Integer locationId) {
        this.id = id;
        this.name = name;
        this.wheelsNumber = wheelsNumber;
        this.vehicleStatus = vehicleStatus;
        this.autonomy = autonomy;
        this.maxSpeed = maxSpeed;
        this.maxPower = maxPower;
        this.maxWeight = maxWeight;
        this.chargingTime = chargingTime;
        this.price = price;
        this.locationId = locationId;

}

    public VehicleResponse(){
        // Constructorul implicit, fara parametri
    }
}
