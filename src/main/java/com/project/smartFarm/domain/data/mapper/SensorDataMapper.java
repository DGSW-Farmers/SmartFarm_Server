package com.project.smartFarm.domain.data.mapper;

import com.project.smartFarm.domain.data.entity.SensorData;
import com.project.smartFarm.domain.data.presentation.dto.request.DailyDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.MonthDataSelectRequest;
import com.project.smartFarm.domain.data.presentation.dto.request.PeriodDataSelectRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SensorDataMapper {

    SensorData periodData(PeriodDataSelectRequest request);

    SensorData dailyData(DailyDataSelectRequest request);

    SensorData monthData(MonthDataSelectRequest request);

}
