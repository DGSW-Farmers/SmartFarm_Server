package com.project.smartFarm.global.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
@Builder
public class SensorDataListResponse {

    private List<SensorDataDetailedResponse> sensorList;

}
