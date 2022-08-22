package com.project.smartFarm.domain.soil.presentation.dto.response;

import com.project.smartFarm.global.type.SoilSensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class SensorDataDetailedResponse {

    private SoilSensorType type;

    private int sensorId;

    private int value;

}
