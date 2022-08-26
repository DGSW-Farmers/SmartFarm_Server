package com.project.smartFarm.domain.hydroponics.service;

import com.project.smartFarm.global.exception.SensorNotFoundException;
import com.project.smartFarm.global.entity.HydroponicsSensorData;
import com.project.smartFarm.global.presentation.dto.response.SensorDataDetailedResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataListResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.global.repository.HydroponicsSensorDataRepository;
import com.project.smartFarm.global.type.SensorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HydroponicsService {

    private final HydroponicsSensorDataRepository hydroponicsSensorDataRepository;

    // 모든 센서 값
    public SensorDataListResponse getSensor() {

        List<HydroponicsSensorData> list = hydroponicsSensorDataRepository.findAll();

        List<SensorDataDetailedResponse> sensorList = list.stream().map(it ->
            SensorDataDetailedResponse.builder()
                    .sensorId(it.getSensorId())
                    .type(it.getType())
                    .value(it.getValue())
                    .build()
        ).collect(Collectors.toList());

        return SensorDataListResponse.builder()
                .sensorList(sensorList)
                .build();
    }
    
    // 센서 종류의 모든 센서 값 가져오기
    public SensorDataListResponse getSensorByType(SensorType type) {

        List<HydroponicsSensorData> list = hydroponicsSensorDataRepository.findAllByType(type);

        List<SensorDataDetailedResponse> sensorList = list.stream().map(it ->
            SensorDataDetailedResponse.builder()
                    .sensorId(it.getSensorId())
                    .type(it.getType())
                    .value(it.getValue())
                    .build()
        ).collect(Collectors.toList());

        return SensorDataListResponse.builder()
                .sensorList(sensorList)
                .build();
    }

    // 센서 종류와 센서 ID로 값 가져오기
    public SensorDataResponse getSensorByTypeAndId(SensorType type, int sensorId) {
        HydroponicsSensorData data = hydroponicsSensorDataRepository.findByTypeAndSensorId(type, sensorId)
                .orElseThrow(() -> {
                    throw SensorNotFoundException.EXCEPTION;
                });

        SensorDataDetailedResponse sensorData = SensorDataDetailedResponse.builder()
                .sensorId(data.getSensorId())
                .type(data.getType())
                .value(data.getValue())
                .build();

        return SensorDataResponse.builder()
                .sensorData(sensorData)
                .build();
    }

}
