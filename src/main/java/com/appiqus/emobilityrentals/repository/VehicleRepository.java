package com.appiqus.emobilityrentals.repository;

import com.appiqus.emobilityrentals.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
