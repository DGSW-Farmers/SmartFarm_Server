package com.project.smartFarm.domain.soil.service;

import com.project.smartFarm.domain.soil.repository.SoilSensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoilService {

    private final SoilSensorDataRepository soilSensorDataRepository;

    // 모든 센서 값

}
