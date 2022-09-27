package com.project.smartFarm.domain.data.presentation;

import com.project.smartFarm.domain.data.presentation.dto.SaveDataRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.AvgListResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.DataListResponse;
import com.project.smartFarm.domain.data.service.SensorService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/hydro")
public class HydroController {

    private final SensorService sensorService;

    @ApiOperation("센서 값 저장")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{device-id}")
    public Long saveData(
            @PathVariable("device-id") int deviceId,
            @RequestBody SaveDataRequest request
    ) {
        log.info("Save SensorData DeviceId : " + deviceId +
                " SensorType : " + request.getType() +
                " SensorValue : " + request.getValue());
        return sensorService.saveData(deviceId, request);
    }

    @ApiOperation("센서 평균 값 가져오기")
    @GetMapping("/avg/{device-id}")
    public AvgListResponse getAvgData(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Get AvgSensorData DeviceId : " + deviceId);
        return sensorService.getAvgData(deviceId);
    }

    @ApiOperation("모든 센서 값 가져오기")
    @GetMapping("/{device-id}")
    public DataListResponse getData(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Get All SensorData DeviceId : " + deviceId);
        return sensorService.getData(deviceId);
    }

}
