package com.project.smartFarm.domain.hydroponics.presentation;

import com.project.smartFarm.domain.hydroponics.service.HydroponicsService;
import com.project.smartFarm.global.presentation.dto.response.SensorDataListResponse;
import com.project.smartFarm.global.presentation.dto.response.SensorDataResponse;
import com.project.smartFarm.global.type.SensorType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(value = "수경재배", tags = {"농장 - 수경재배"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/hydroponics")
public class HydroponicsController {

    private final HydroponicsService hydroponicsService;

    @ApiOperation(value = "수경 센서 값 모두 가져오기")
    @GetMapping("")
    public SensorDataListResponse getSensorData() {
        return hydroponicsService.getSensor();

    }

    @ApiOperation(value = "수경 센서 종류의 모든 값 가져오기")
    @GetMapping("/{sensor-type}")
    public SensorDataListResponse getSensorByType(
            @PathVariable("sensor-type") SensorType type
    ) {
        return hydroponicsService.getSensorByType(type);
    }

    @ApiOperation(value = "수경 센서 종류와 센서 ID로 값 가져오기")
    @GetMapping("/{sensor-type}/{sensor-id}")
    public SensorDataResponse getSensorByTypeAndSensorId(
            @PathVariable("sensor-type") SensorType type,
            @PathVariable("sensor-id") int sensorId
    ) {
        return hydroponicsService.getSensorByTypeAndId(type, sensorId);
    }

    @ApiOperation(value = "수경 센서의 (LED, 워터펌프, 환풍기 조작)")
    @PostMapping("/{sensor-type}/{sensor-id}")
    public SensorDataResponse modifySensorData(
            @PathVariable("sensor-type") SensorType type,
            @PathVariable("sensor-id") int sensorId,
            @RequestParam("value") String value
    ) {
        return hydroponicsService.modifySensor(type, sensorId, value);
    }

}
