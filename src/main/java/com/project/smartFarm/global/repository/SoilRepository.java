package com.project.smartFarm.global.repository;

import com.project.smartFarm.global.entity.Soil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilRepository extends JpaRepository<Soil, Long> {
}
