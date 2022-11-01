package com.project.smartFarm.domain.data.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter @NoArgsConstructor
public class DailyDataSelectRequest {

    private int deviceId;
    private LocalDate date;

}
