package com.project.smartFarm.domain.data.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class SaveDataRequest {

    private String temperature;
    private String humidity;
    private String led;
    private String pan;
    private String sunlight;
    private String pump;
    private String liquid;
    private String waterLevel;

}
