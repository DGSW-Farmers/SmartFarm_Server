package com.project.smartFarm.domain.hydroponics.presentation.dto.request;

import com.project.smartFarm.global.type.SensorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class SaveSensorDataRequest {

    private int sensorId;

    private SensorType type;

    private String value;

}
