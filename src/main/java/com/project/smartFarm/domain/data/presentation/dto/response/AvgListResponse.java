package com.project.smartFarm.domain.data.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
@Builder
public class AvgListResponse {

    private int deviceId;

    private List<AvgSensorDataResponse> avgData;

}
