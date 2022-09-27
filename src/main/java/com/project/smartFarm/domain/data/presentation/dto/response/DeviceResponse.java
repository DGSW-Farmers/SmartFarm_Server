package com.project.smartFarm.domain.data.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class DeviceResponse {

    private int deviceId;

    private String name;

    private String startDate;

    private String endDate;

}
