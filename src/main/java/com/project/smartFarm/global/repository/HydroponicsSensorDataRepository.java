package com.project.smartFarm.global.repository;

import com.project.smartFarm.global.entity.HydroponicsSensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HydroponicsSensorDataRepository extends JpaRepository<HydroponicsSensorData, Long> {
}
