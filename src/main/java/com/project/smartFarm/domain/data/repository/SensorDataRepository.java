package com.project.smartFarm.domain.data.repository;

import com.project.smartFarm.domain.data.entity.Device;
import com.project.smartFarm.domain.data.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    @Query(value = "SELECT " +
            "0 AS id, " +
            "device_id, " +
            "sysdate() AS save_date, " +
            "AVG(temperature) AS temperature, " +
            "AVG(humidity) AS humidity, " +
            "AVG(led) AS led, " +
            "AVG(pan) AS pan, " +
            "AVG(sunlight) AS sunlight, " +
            "AVG(pump) AS pump, " +
            "AVG(liquid) AS liquid, " +
            "AVG(water_level) AS water_level " +
            "FROM sensor_data WHERE device_id=? GROUP BY device_id", nativeQuery = true)
    Optional<SensorData> findByDevicAvgSensorData(Device device);

    List<SensorData> findAllByDevice(Device device);

}
