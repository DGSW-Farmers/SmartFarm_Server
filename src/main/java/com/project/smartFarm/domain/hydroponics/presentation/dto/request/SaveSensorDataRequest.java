package com.project.smartFarm.domain.hydroponics.presentation.dto.request;

import com.project.smartFarm.global.type.SensorType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveSensorDataRequest {

    private int sensorId;

    private String value;

    private SensorType type;

}
