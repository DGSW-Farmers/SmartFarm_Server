package com.project.smartFarm.domain.hydroponics.repository;

import com.project.smartFarm.domain.hydroponics.entity.HydroponicsSensorData;
import com.project.smartFarm.global.type.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HydroponicsSensorDataRepository extends JpaRepository<HydroponicsSensorData, Long> {

    List<HydroponicsSensorData> findAllByType(SensorType type);

    Optional<HydroponicsSensorData> findByTypeAndSensorId(SensorType type, int sensorId);

}