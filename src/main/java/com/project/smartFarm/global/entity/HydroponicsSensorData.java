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

    @ManyToOne
    @JoinColumn
    private Hydroponics hydroponics;

    @Enumerated(value = EnumType.STRING)
    private SensorType type;

    private int sensorId;

    private int value;

    @Builder
    public HydroponicsSensorData(Long id, Hydroponics hydroponics, SensorType type, int sensorId, int value) {
        this.id = id;
        this.hydroponics = hydroponics;
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}
