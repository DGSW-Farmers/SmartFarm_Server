package com.project.smartFarm.domain.data.presentation;

import com.project.smartFarm.domain.data.presentation.dto.RegistDeviceRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.DeviceResponse;
import com.project.smartFarm.domain.data.service.DeviceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/device")
public class DeviceController {

    private final DeviceService deviceService;

    @ApiOperation("기기를 등록합니다")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public int registDevice(
            @RequestBody RegistDeviceRequest request
    ) {
        log.info("Regist DeviceId : " + request.getDeviceId()
                + " Name : " + request.getName());
        return deviceService.registDevice(request);
    }

    @ApiOperation("기기정보를 가지고 옵니다")
    @GetMapping("/{device-id}")
    public DeviceResponse getDevice(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Get DeviceId : " + deviceId);
        return deviceService.getDevice(deviceId);
    }

    @ApiOperation("기기를 종료합니다")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/termite/{device-id}")
    public void TermiteDevice(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Termite DeviceId : " + deviceId);
        deviceService.TermiteDevice(deviceId);
    }

}
