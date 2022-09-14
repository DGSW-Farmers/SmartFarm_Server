package com.project.smartFarm.domain.hydroponics.repository;

import com.project.smartFarm.domain.hydroponics.entity.Hydroponics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HydroponicsRepository extends JpaRepository<Hydroponics, Long> {

    Optional<Hydroponics> findByDeviceId(int deviceId);

}
