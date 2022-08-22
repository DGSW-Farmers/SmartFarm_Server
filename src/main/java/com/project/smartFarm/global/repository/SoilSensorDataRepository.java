package com.project.smartFarm.global.repository;

import com.project.smartFarm.global.entity.SoilSensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilSensorDataRepository extends JpaRepository<SoilSensorData, Long> {
}
