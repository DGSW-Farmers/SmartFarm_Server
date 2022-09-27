package com.project.smartFarm.domain.data.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @AllArgsConstructor
@Builder
public class DataListResponse {

    private int deviceId;

    private List<SensorDataResponse> list;

}
