package com.project.smartFarm.domain.data.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class AvgSensorDataResponse {

    private String temperature;
    private String humidity;
    private String led;
    private String pan;
    private String sunlight;
    private String pump;
    private String liquid;
    private String waterLevel;

}
