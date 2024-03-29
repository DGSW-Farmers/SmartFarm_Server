package com.project.smartFarm.domain.data.presentation;

import com.project.smartFarm.domain.data.presentation.dto.request.DailyDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.MonthDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.PeriodDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.SaveDataRequest;
import com.project.smartFarm.domain.data.presentation.dto.response.AvgResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.DataListResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.SensorDataResponse;
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
        log.info("Save :: SensorData DeviceId : " + deviceId);
        return sensorService.saveData(deviceId, request);
    }

    @ApiOperation("마지막 날의 값 가져오기")
    @GetMapping("/last/{device-id}")
    public SensorDataResponse getLataDateData(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Get :: LastDateData DeviceId : " + deviceId);
        return sensorService.getLastDateData(deviceId);
    }

    @ApiOperation("센서 평균 값 가져오기")
    @GetMapping("/avg/{device-id}")
    public AvgResponse getAvgData(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Get :: AvgSensorData DeviceId : " + deviceId);
        return sensorService.getAvgData(deviceId);
    }

    @ApiOperation("모든 센서 값 가져오기")
    @GetMapping("/{device-id}")
    public DataListResponse getData(
            @PathVariable("device-id") int deviceId
    ) {
        log.info("Get :: All SensorData DeviceId : " + deviceId);
        return sensorService.getData(deviceId);
    }

    @ApiOperation("일별 평균 센서 값 가져오기")
    @GetMapping("/daily")
    public AvgResponse getDailyData(
            @RequestBody DailyDataSelectRequest request
    ) {
        log.info("Get :: DailyData DeviceId : " + request.getDeviceId());
        return sensorService.getDailyAvgData(request);
    }

    @ApiOperation("월별 평균 센서 값 가져오기")
    @GetMapping("/month")
    public AvgResponse getMonthData(
            @RequestBody MonthDataSelectRequest request
    ) {
        log.info("Get :: MonthData DeviceId : " + request.getDeviceId());
        return sensorService.getMonthAvgData(request);
    }

    @ApiOperation("기간별 센서 값 가져오기")
    @GetMapping("/period")
    public AvgResponse getPeriodData(
            @RequestBody PeriodDataSelectRequest request
    ) {
        log.info("Get :: PeriodData DeviceId : " + request.getDeviceId());
        return sensorService.getPeriodData(request);
    }
}
