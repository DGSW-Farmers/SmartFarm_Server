package com.project.smartFarm.domain.soil.service;

import com.project.smartFarm.global.presentation.dto.response.SensorDataDetailedResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataListResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.domain.soil.entity.SoilSensorData;
import com.project.smartFarm.global.exception.SensorNotFoundException;
import com.project.smartFarm.domain.soil.repository.SoilSensorDataRepository;
import com.project.smartFarm.global.type.SensorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SoilService {

    private final SoilSensorDataRepository soilSensorDataRepository;

    // 모든 센서 값
    public SensorDataListResponse getSensor() {
        List<SoilSensorData> list = soilSensorDataRepository.findAll();

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

        List<SoilSensorData> list = soilSensorDataRepository.findAllByType(type);

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
        SoilSensorData data = soilSensorDataRepository.findByTypeAndSensorId(type, sensorId)
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
