package com.project.smartFarm.global.repository;

import com.project.smartFarm.global.entity.HydroponicsSensorData;
import com.project.smartFarm.global.type.HydroponicsSensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HydroponicsSensorDataRepository extends JpaRepository<HydroponicsSensorData, Long> {

    List<HydroponicsSensorData> findAllByType(HydroponicsSensorType type);

    Optional<HydroponicsSensorData> findByTypeAndSensorId(HydroponicsSensorType type, int sensorId);

}
