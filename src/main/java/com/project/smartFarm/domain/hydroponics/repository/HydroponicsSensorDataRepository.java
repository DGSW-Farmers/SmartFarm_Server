package com.project.smartFarm.domain.hydroponics.repository;

import com.project.smartFarm.domain.hydroponics.entity.HydroponicsSensorData;
import com.project.smartFarm.global.type.SensorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HydroponicsSensorDataRepository extends JpaRepository<HydroponicsSensorData, Long> {

    List<HydroponicsSensorData> findAllByType(SensorType type);

    Optional<HydroponicsSensorData> findByTypeAndSensorId(SensorType type, int sensorId);

    @Query(value = "SELECT " +
            "0 AS id, " +
            "0 AS sensor_id, " +
            "device_id, " +
            "type, " +
            "sysdate() AS save_time, " +
            "AVG(value) AS value " +
            "FROM hydroponics_sensor_data WHERE type=? AND device_id=?", nativeQuery = true)
    Optional<HydroponicsSensorData> findAvgByTypeAndDeviceId(String type, int deviceId);
}
