package com.project.smartFarm.global.repository;

import com.project.smartFarm.global.entity.Hydroponics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HydroponicsRepository extends JpaRepository<Hydroponics, Long> {
}
