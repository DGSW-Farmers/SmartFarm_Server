package com.project.smartFarm.domain.hydroponics.service;

import com.project.smartFarm.domain.hydroponics.entity.Hydroponics;
import com.project.smartFarm.domain.hydroponics.presentation.dto.request.SaveSensorDataRequest;
import com.project.smartFarm.domain.hydroponics.repository.HydroponicsRepository;
import com.project.smartFarm.global.exception.DeviceAlreadyExistsException;
import com.project.smartFarm.global.exception.DeviceNotFoundException;
import com.project.smartFarm.global.exception.SensorNotFoundException;
import com.project.smartFarm.domain.hydroponics.entity.HydroponicsSensorData;
import com.project.smartFarm.global.presentation.dto.response.SensorDataDetailedResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataListResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.domain.hydroponics.repository.HydroponicsSensorDataRepository;
import com.project.smartFarm.global.type.SensorType;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HydroponicsService {

    private final HydroponicsSensorDataRepository hydroponicsSensorDataRepository;
    private final HydroponicsRepository hydroponicsRepository;

    // 모든 센서 값
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
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

    @Transactional
    public void registerDevice(int deviceId) {
        hydroponicsRepository.findByDeviceId(deviceId)
                .ifPresent(m -> {
                    throw DeviceAlreadyExistsException.EXCEPTION;
                });

        hydroponicsRepository.save(new Hydroponics(deviceId));
    }

    @Transactional
    public void saveSensorData(int deviceId, SaveSensorDataRequest request) {

        Hydroponics device = hydroponicsRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> {
                    throw DeviceNotFoundException.EXCEPTION;
                });

        HydroponicsSensorData data = HydroponicsSensorData.builder()
                .sensorId(request.getSensorId())
                .type(request.getType())
                .value(request.getValue())
                .build();

        device.addSensorData(data);
    }

}
