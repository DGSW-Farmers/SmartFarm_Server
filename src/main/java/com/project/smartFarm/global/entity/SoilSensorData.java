package com.project.smartFarm.global.entity;

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

    private int value;

    @Builder
    public SoilSensorData(Long id, SensorType type, int sensorId, int value) {
        this.id = id;
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}
