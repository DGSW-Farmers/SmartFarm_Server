package com.project.smartFarm.domain.data.service;

import com.project.smartFarm.domain.data.entity.Device;
import com.project.smartFarm.domain.data.entity.SensorData;
import com.project.smartFarm.domain.data.exception.DeviceNotFoundException;
import com.project.smartFarm.domain.data.presentation.dto.SaveDataRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.AvgResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.AvgSensorDataResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.DataListResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.domain.data.repository.DeviceRepository;
import com.project.smartFarm.domain.data.repository.SensorDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorService {

    private final DeviceRepository deviceRepository;
    private final SensorDataRepository sensorDataRepository;

    @Transactional
    public Long saveData(int deviceId, SaveDataRequest request) {

        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        SensorData data = SensorData.builder()
                .device(device)
                .temperature(request.getTemperature())
                .humidity(request.getHumidity())
                .liquid(request.getLiquid())
                .sunlight(request.getSunlight())
                .waterLevel(request.getWaterLevel())
                .led(request.getLed())
                .pump(request.getPump())
                .pan(request.getPan())
                .build();
        device.addData(data);

        log.info("Save sensorData");
        return data.getId();
    }

    @Transactional(readOnly = true)
    public AvgResponse getAvgData(int deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);
        SensorData data = sensorDataRepository.findByDevicAvgSensorData(device)
                .orElseThrow();

        log.info("Get Average SensorData");
        return AvgResponse.builder()
                .deviceId(device.getDeviceId())
                .avgData(AvgSensorDataResponse.builder()
                        .temperature(data.getTemperature())
                        .humidity(data.getHumidity())
                        .liquid(data.getLiquid())
                        .sunlight(data.getSunlight())
                        .waterLevel(data.getWaterLevel())
                        .led(data.getLed())
                        .pump(data.getPump())
                        .pan(data.getPan())
                        .build()
                )
                .build();
    }

    @Transactional(readOnly = true)
    public DataListResponse getData(int deviceId) {

        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        List<SensorData> data = sensorDataRepository.findAllByDevice(device);

        List<SensorDataResponse> list = data.stream().map(it ->
                        SensorDataResponse.builder()
                                .temperature(it.getTemperature())
                                .humidity(it.getHumidity())
                                .liquid(it.getLiquid())
                                .sunlight(it.getSunlight())
                                .waterLevel(it.getWaterLevel())
                                .led(it.getLed())
                                .pump(it.getPump())
                                .pan(it.getPan())
                                .build()
                ).collect(Collectors.toList());

        log.info("Get All SensorData");
        return DataListResponse.builder()
                .deviceId(deviceId)
                .list(list)
                .build();
    }

}
