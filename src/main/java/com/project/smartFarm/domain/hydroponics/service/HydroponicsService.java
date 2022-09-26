package com.project.smartFarm.domain.hydroponics.service;

import com.project.smartFarm.domain.hydroponics.entity.HydroponicsSensorData;
import com.project.smartFarm.domain.hydroponics.exception.DeviceAndTypeNotFoundException;
import com.project.smartFarm.domain.hydroponics.presentation.dto.request.SaveSensorDataRequest;
import com.project.smartFarm.domain.hydroponics.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.domain.hydroponics.repository.HydroponicsSensorDataRepository;
import com.project.smartFarm.global.type.SensorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HydroponicsService {

    private final HydroponicsSensorDataRepository hydroponicsSensorDataRepository;

    // 센서 값 저장
    @Transactional
    public void saveSensorData(int deviceId, SaveSensorDataRequest request) {
        HydroponicsSensorData data = HydroponicsSensorData.builder()
                .deviceId(deviceId).sensorId(request.getSensorId())
                .type(request.getType()).value(request.getValue())
                .build();

        hydroponicsSensorDataRepository.save(data);
    }

    @Transactional(readOnly = true)
    public SensorDataResponse getAvgSensorData(int deviceId, SensorType type) {

        HydroponicsSensorData data = hydroponicsSensorDataRepository
                .findAvgByTypeAndDeviceId(String.valueOf(type), deviceId)
                .orElseThrow(DeviceAndTypeNotFoundException::new);

        return SensorDataResponse.builder()
                .deviceId(data.getDeviceId())
                .type(data.getType())
                .avgValue(data.getValue())
                .build();
    }

}
