package com.project.smartFarm.domain.soil.entity;

import com.project.smartFarm.global.type.SensorType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SoilSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SensorType type;

    private int sensorId;

    private String value;

    @Builder
    public SoilSensorData(Long id, SensorType type, int sensorId, String value) {
        this.id = id;
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}