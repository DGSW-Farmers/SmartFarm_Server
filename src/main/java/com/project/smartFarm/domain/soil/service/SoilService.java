package com.project.smartFarm.domain.soil.service;

import com.project.smartFarm.global.repository.SoilRepository;
import com.project.smartFarm.global.repository.SoilSensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoilService {

    private final SoilRepository soilRepository;
    private final SoilSensorDataRepository soilSensorDataRepository;

    // 모든 센서 값
    public void getSensor() {

    }

}
