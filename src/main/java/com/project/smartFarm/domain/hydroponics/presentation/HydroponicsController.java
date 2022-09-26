package com.project.smartFarm.domain.hydroponics.presentation;

import com.project.smartFarm.domain.hydroponics.presentation.dto.request.SaveSensorDataRequest;
import com.project.smartFarm.domain.hydroponics.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.domain.hydroponics.service.HydroponicsService;
import com.project.smartFarm.global.type.SensorType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(value = "수경재배", tags = {"농장 - 수경재배"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/hydroponics")
public class HydroponicsController {

    private final HydroponicsService hydroponicsService;

    @ApiOperation(value = "센서값 저장")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/save/{device-id}")
    public void saveSensorData(
            @PathVariable("device-id") int deviceId,
            @RequestBody SaveSensorDataRequest request
    ) {
        hydroponicsService.saveSensorData(deviceId, request);
    }

    @ApiOperation("센서 평균 값 가져오기")
    @GetMapping("/avg/{device-id}/{sensor-type}")
    public SensorDataResponse getAvgSensorData(
            @PathVariable("device-id") int deviceId,
            @PathVariable("sensor-type") SensorType type
    ) {
        return hydroponicsService.getAvgSensorData(deviceId, type);
    }
}
