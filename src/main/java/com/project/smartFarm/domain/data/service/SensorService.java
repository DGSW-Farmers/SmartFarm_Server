package com.project.smartFarm.domain.data.service;

import com.project.smartFarm.domain.data.entity.Device;
import com.project.smartFarm.domain.data.entity.SensorData;
import com.project.smartFarm.domain.data.exception.DeviceNotFoundException;
import com.project.smartFarm.domain.data.presentation.dto.SaveDataRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.AvgListResponse;
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
                .type(request.getType())
                .value(request.getValue())
                .build();
        device.addData(data);

        log.info("Save sensorData");
        return data.getId();
    }

    @Transactional(readOnly = true)
    public AvgListResponse getAvgData(int deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);
        List<SensorData> list = sensorDataRepository.findAllByDevicAvgSensorData(device);

        List<AvgSensorDataResponse> avgList = list.stream().map(it ->
                AvgSensorDataResponse.builder()
                        .type(it.getType())
                        .avgValue(it.getValue())
                        .build()
                ).collect(Collectors.toList());

        log.info("Get Average SensorData");
        return AvgListResponse.builder()
                .deviceId(deviceId)
                .avgList(avgList)
                .build();
    }

    @Transactional(readOnly = true)
    public DataListResponse getData(int deviceId) {

        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        List<SensorData> datas = sensorDataRepository.findAllByDevice(device);

        List<SensorDataResponse> list = datas.stream().map(it ->
                SensorDataResponse.builder()
                        .type(it.getType())
                        .value(it.getValue())
                        .build()
                ).collect(Collectors.toList());

        log.info("Get All SensorData");
        return DataListResponse.builder()
                .deviceId(deviceId)
                .list(list)
                .build();
    }

}
