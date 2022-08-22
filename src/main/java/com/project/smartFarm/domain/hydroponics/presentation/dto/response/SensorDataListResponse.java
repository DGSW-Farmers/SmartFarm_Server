package com.project.smartFarm.domain.hydroponics.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
@Builder
public class SensorDataListResponse {

    private List<SensorDataDetailedResponse> sensorList;

}
