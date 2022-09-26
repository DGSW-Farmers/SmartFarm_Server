package com.project.smartFarm.domain.hydroponics.entity;

import com.project.smartFarm.global.type.SensorType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "hydroponics_sensor_data")
public class HydroponicsSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int deviceId;

    @Enumerated(value = EnumType.STRING)
    private SensorType type;

    private int sensorId;

    private String value;

    @CreationTimestamp
    private LocalDateTime saveTime;

    @Builder
    public HydroponicsSensorData(int deviceId, SensorType type, int sensorId, String value) {
        this.deviceId = deviceId;
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}
