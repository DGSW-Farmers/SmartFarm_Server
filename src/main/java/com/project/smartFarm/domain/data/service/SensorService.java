package com.project.smartFarm.domain.data.service;

import com.project.smartFarm.domain.data.entity.Device;
import com.project.smartFarm.domain.data.entity.SensorData;
import com.project.smartFarm.domain.data.exception.DeviceNotFoundException;
import com.project.smartFarm.domain.data.mapper.SensorDataMapper;
import com.project.smartFarm.domain.data.presentation.dto.request.DailyDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.MonthDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.PeriodDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.SaveDataRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.*;
import com.project.smartFarm.domain.data.repository.DeviceRepository;
import com.project.smartFarm.domain.data.repository.SensorDataRepository;
import com.project.smartFarm.global.exception.BusinessException;
import com.project.smartFarm.global.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    private final SensorDataMapper sensorDataMapper;

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
    public SensorDataResponse getLastDateData(int deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        SensorData data = sensorDataRepository.findFirstByDeviceOrderBySaveDateDesc(device);

        log.info("Get Last SensorData");
        return ResponseUtils.getSensorData(data);
    }

    @Transactional(readOnly = true)
    public AvgResponse getAvgData(int deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);
        SensorData data = sensorDataRepository.findByDevicAvgSensorData(device);

        log.info("Get Average SensorData");
        return AvgResponse.builder()
                .deviceId(device.getDeviceId())
                .avgData(ResponseUtils.getAvgSensorData(data))
                .build();
    }

    @Transactional(readOnly = true)
    public DataListResponse getData(int deviceId) {

        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        List<SensorData> data = sensorDataRepository.findAllByDevice(device);

        List<SensorDataResponse> list = data.stream()
                .map(ResponseUtils::getSensorData)
                .collect(Collectors.toList());

        log.info("Get All SensorData");
        return DataListResponse.builder()
                .deviceId(deviceId)
                .list(list)
                .build();
    }

    @Transactional(readOnly = true)
    public AvgResponse getDailyAvgData(DailyDataSelectRequest request) {
        Device device = deviceRepository.findByDeviceId(request.getDeviceId())
                .orElseThrow(DeviceNotFoundException::new);

        SensorData data = sensorDataMapper.dailyData(request);

        log.info("data : " + data);
        if (data == null) throw new BusinessException(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다");

        return new AvgResponse(request.getDeviceId(), ResponseUtils.getAvgSensorData(data));
    }

    @Transactional(readOnly = true)
    public AvgResponse getMonthAvgData(MonthDataSelectRequest request) {
        Device device = deviceRepository.findByDeviceId(request.getDeviceId())
                .orElseThrow(DeviceNotFoundException::new);

        SensorData data = sensorDataMapper.monthData(request);

        log.info("data : " + data);
        if (data == null) throw new BusinessException(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다");

        return new AvgResponse(request.getDeviceId(), ResponseUtils.getAvgSensorData(data));
    }

    @Transactional(readOnly = true)
    public AvgResponse getPeriodData(PeriodDataSelectRequest request) {
        Device device = deviceRepository.findByDeviceId(request.getDeviceId())
                .orElseThrow(DeviceNotFoundException::new);

        SensorData data = sensorDataMapper.periodData(request);

        if(data == null) throw new BusinessException(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다");

        return new AvgResponse(device.getDeviceId(), ResponseUtils.getAvgSensorData(data));

    }

}
