package com.project.smartFarm.global.presentation.dto.response;

import com.project.smartFarm.global.type.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class SensorDataDetailedResponse {

    private SensorType type;

    private int sensorId;

    private String value;

}
