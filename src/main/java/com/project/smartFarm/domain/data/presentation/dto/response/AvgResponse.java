package com.project.smartFarm.domain.data.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class AvgResponse {

    private int deviceId;

    private AvgSensorDataResponse avgData;

}
