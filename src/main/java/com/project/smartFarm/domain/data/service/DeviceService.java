package com.project.smartFarm.domain.data.service;

import com.project.smartFarm.domain.data.entity.Device;
import com.project.smartFarm.domain.data.exception.DeviceAlreadyExistsException;
import com.project.smartFarm.domain.data.exception.DeviceNotFoundException;
import com.project.smartFarm.domain.data.presentation.dto.request.RegistDeviceRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.DeviceResponse;
import com.project.smartFarm.domain.data.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Transactional
    public int registDevice(RegistDeviceRequest request) {

        deviceRepository.findByDeviceId(request.getDeviceId())
                .ifPresent(m -> {
                    throw new DeviceAlreadyExistsException();
                });

        Device device = Device.builder()
                .deviceId(request.getDeviceId())
                .name(request.getName())
                .dataList(new ArrayList<>())
                .build();
        device = deviceRepository.save(device);

        log.info("Regist device");
        return device.getDeviceId();
    }

    @Transactional(readOnly = true)
    public DeviceResponse getDevice(int deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        log.info("Get device info");
        return DeviceResponse.builder()
                .deviceId(device.getDeviceId())
                .name(device.getName())
                .startDate(new SimpleDateFormat("yyyy-MM-dd")
                        .format(Date.from(
                                device.getStartDate().atZone(ZoneId.systemDefault()).toInstant()
                        )))
                .endDate(device.getEndDate() != null ? new SimpleDateFormat("yyyy-MM-dd")
                        .format(Date.from(
                                device.getEndDate().atZone(ZoneId.systemDefault()).toInstant()
                        )) : null)
                .build();
    }

    @Transactional
    public void TermiteDevice(int deviceId) {
        Device device = deviceRepository.findByDeviceId(deviceId)
                .orElseThrow(DeviceNotFoundException::new);

        device.termiteDevice();
        log.info("Termite device");
    }

}
