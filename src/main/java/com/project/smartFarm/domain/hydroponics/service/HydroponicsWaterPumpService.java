package com.project.smartFarm.domain.hydroponics.service;

import com.project.smartFarm.global.repository.HydroponicsRepository;
import com.project.smartFarm.global.repository.HydroponicsSensorDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HydroponicsWaterPumpService {

    private final HydroponicsRepository hydroponicsRepository;
    private final HydroponicsSensorDataRepository hydroponicsSensorDataRepository;

    // 모든 워터펌프 값
    public void getWaterPump() {

    }

    // 워터펌프 ID로 값 가져오기
    public void getWaterPumpById() {

    }

}
