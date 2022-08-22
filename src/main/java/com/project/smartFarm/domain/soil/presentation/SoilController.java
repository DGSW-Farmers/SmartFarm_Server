package com.project.smartFarm.domain.soil.presentation;

import com.project.smartFarm.domain.soil.presentation.dto.response.SensorDataListResponse;
import com.project.smartFarm.domain.soil.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.domain.soil.service.SoilService;
import com.project.smartFarm.global.type.SoilSensorType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "토경재배", tags = {"농장 - 토경재배"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/soil")
public class SoilController {

    private final SoilService soilService;

    @GetMapping("")
    public SensorDataListResponse getSensorData() {
        return soilService.getSensor();
    }

    @ApiOperation(value = "토경 센서 종류의 모든 값 가져오기")
    @GetMapping("/{sensor-type}")
    public SensorDataListResponse getSensorByType(
            @PathVariable("sensor-type") SoilSensorType type
    ) {
        return soilService.getSensorByType(type);
    }

    @ApiOperation(value = "토경 센서 종류와 센서 ID로 값 가져오기")
    @GetMapping("/{sensor-type}/{sensor-id}")
    public SensorDataResponse getSensorByTypeAndSensorId(
            @PathVariable("sensor-type") SoilSensorType type,
            @PathVariable("sensor-id") int sensorId
    ) {
        return soilService.getSensorByTypeAndId(type, sensorId);
    }

}
