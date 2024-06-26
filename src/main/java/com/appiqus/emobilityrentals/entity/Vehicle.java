package com.appiqus.emobilityrentals.entity;

import com.appiqus.emobilityrentals.entity.enums.VehicleStatus;
import com.appiqus.emobilityrentals.entity.enums.WheelsNumber;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(name = "wheels_number")
    @Enumerated(EnumType.STRING)
    private WheelsNumber wheelsNumber;

    @Column(name = "vehicle_status")
    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    private Double autonomy;
    private Double maxSpeed;
    private Double maxPower;
    private Double maxWeight;
    private Double chargingTime;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    public void addVehicleToLocation(Location location)
    {
        location.getVehicle().add(this);
        this.location = location;
    }

    public void removeVehicleFromLocation(Location location)
    {
        location.getVehicle().remove(this);
        this.location = null;
    }

}
