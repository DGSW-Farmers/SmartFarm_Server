package com.project.smartFarm.domain.hydroponics.service;

import com.project.smartFarm.global.repository.HydroponicsRepository;
import com.project.smartFarm.global.repository.HydroponicsSensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HydroponicsLevelService {

    private final HydroponicsRepository hydroponicsRepository;
    private final HydroponicsSensorDataRepository hydroponicsSensorDataRepository;

    // 모든 수위 센서 값
    public void getLevelSensor() {

    }

    // 수위 센서 ID로 값 가져오기
    public void getLevelSensorById() {

    }

}
