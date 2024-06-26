package com.appiqus.emobilityrentals.repository;

import com.appiqus.emobilityrentals.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
