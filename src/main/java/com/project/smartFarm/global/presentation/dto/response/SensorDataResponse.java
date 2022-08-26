package com.project.smartFarm.global.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class SensorDataResponse {

    private SensorDataDetailedResponse sensorData;

}
