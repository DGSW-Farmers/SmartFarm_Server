package com.project.smartFarm.domain.data.presentation.dto;

import com.project.smartFarm.domain.data.type.SensorType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor
public class SaveDataRequest {

    private SensorType type;

    private String value;

}
