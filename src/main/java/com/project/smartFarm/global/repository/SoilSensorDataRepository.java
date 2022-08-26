package com.project.smartFarm.global.repository;

import com.project.smartFarm.global.entity.SoilSensorData;
import com.project.smartFarm.global.type.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SoilSensorDataRepository extends JpaRepository<SoilSensorData, Long> {

    List<SoilSensorData> findAllByType(SensorType type);

    Optional<SoilSensorData> findByTypeAndSensorId(SensorType type, int sensorId);

}
