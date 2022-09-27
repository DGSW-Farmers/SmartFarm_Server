package com.project.smartFarm.domain.data.repository;

import com.project.smartFarm.domain.data.entity.Device;
import com.project.smartFarm.domain.data.entity.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    @Query(value = "SELECT " +
            "0 AS id, " +
            "device_id, " +
            "type, " +
            "sysdate() AS save_date, " +
            "AVG(value) AS value " +
            "FROM sensor_data WHERE device_id=? GROUP BY type", nativeQuery = true)
    List<SensorData> findAvgByDeviceId(int deviceId);

    List<SensorData> findAllByDevice(Device device);

}
