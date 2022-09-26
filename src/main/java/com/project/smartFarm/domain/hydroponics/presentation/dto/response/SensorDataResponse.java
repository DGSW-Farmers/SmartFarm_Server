package com.project.smartFarm.domain.hydroponics.presentation.dto.response;

import com.project.smartFarm.global.type.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class SensorDataResponse {

    private int deviceId;

    private SensorType type;

    private String avgValue;

}
