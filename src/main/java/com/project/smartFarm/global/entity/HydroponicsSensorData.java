package com.project.smartFarm.global.entity;

import com.project.smartFarm.global.type.SensorType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HydroponicsSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SensorType type;

    private int sensorId;

    private String value;

    @Builder
    public HydroponicsSensorData(Long id, SensorType type, int sensorId, String value) {
        this.id = id;
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}
