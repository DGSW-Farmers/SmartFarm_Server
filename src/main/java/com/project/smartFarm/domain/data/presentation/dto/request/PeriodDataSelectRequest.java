package com.project.smartFarm.domain.data.presentation.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter @NoArgsConstructor
public class PeriodDataSelectRequest {

    private LocalDate start;

    private LocalDate end;

    private int deviceId;

}
