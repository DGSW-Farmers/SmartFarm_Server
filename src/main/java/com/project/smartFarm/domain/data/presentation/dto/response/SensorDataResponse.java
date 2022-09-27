package com.project.smartFarm.domain.data.presentation.dto.response;

import com.project.smartFarm.domain.data.type.SensorType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class SensorDataResponse {

    private SensorType type;

    private String value;

}
