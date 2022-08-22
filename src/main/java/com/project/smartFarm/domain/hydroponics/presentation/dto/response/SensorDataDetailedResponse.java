package com.project.smartFarm.domain.hydroponics.presentation.dto.response;

import com.project.smartFarm.global.type.HydroponicsSensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class SensorDataDetailedResponse {

    private HydroponicsSensorType type;

    private int sensorId;

    private int value;

}
