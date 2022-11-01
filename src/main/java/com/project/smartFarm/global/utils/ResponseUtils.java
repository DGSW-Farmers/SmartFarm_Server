package com.project.smartFarm.global.utils;

import com.project.smartFarm.domain.data.entity.SensorData;
import com.project.smartFarm.domain.data.presentation.dto.response.AvgSensorDataResponse;
import com.project.smartFarm.domain.data.presentation.dto.response.SensorDataResponse;

public class ResponseUtils {

    public static SensorDataResponse getSensorData(SensorData data) {
        return SensorDataResponse.builder()
                .temperature(data.getTemperature())
                .humidity(data.getHumidity())
                .liquid(data.getLiquid())
                .sunlight(data.getSunlight())
                .waterLevel(data.getWaterLevel())
                .led(data.getLed())
                .pump(data.getPump())
                .pan(data.getPan())
                .build();
    }

    public static AvgSensorDataResponse getAvgSensorData(SensorData data) {
        return AvgSensorDataResponse.builder()
                .temperature(data.getTemperature())
                .humidity(data.getHumidity())
                .liquid(data.getLiquid())
                .sunlight(data.getSunlight())
                .waterLevel(data.getWaterLevel())
                .led(data.getLed())
                .pump(data.getPump())
                .pan(data.getPan())
                .build();
    }

}
