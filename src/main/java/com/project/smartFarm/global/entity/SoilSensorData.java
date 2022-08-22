package com.project.smartFarm.global.entity;

import com.project.smartFarm.global.type.HydroponicsSensorType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SoilSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Soil soil;

    @Enumerated(value = EnumType.STRING)
    private HydroponicsSensorType type;

    private int sensorId;

    private int value;

    @Builder
    public SoilSensorData(Long id, Soil soil, HydroponicsSensorType type, int sensorId, int value) {
        this.id = id;
        this.soil = soil;
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}
