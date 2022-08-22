package com.project.smartFarm.domain.soil.service;

import com.project.smartFarm.global.repository.SoilRepository;
import com.project.smartFarm.global.repository.SoilSensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoilMoistureService {

    private final SoilRepository soilRepository;
    private final SoilSensorDataRepository soilSensorDataRepository;

    // 모든 토양 수분 센서 값
    public void getMoistureSensor() {

    }

    // 토양 수분 센서 ID로 값 가져오기
    public void getMoistureSensorById() {

    }

}
