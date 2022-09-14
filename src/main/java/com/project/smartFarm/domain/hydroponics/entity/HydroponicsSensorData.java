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
public class HydroponicsSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private SensorType type;

    private int sensorId;

    private String value;

    @CreationTimestamp
    private LocalDateTime saveTime;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Hydroponics device;
    public void setDevice(Hydroponics device) {
        this.device = device;
    }

    @Builder
    public HydroponicsSensorData(SensorType type, int sensorId, String value) {
        this.type = type;
        this.sensorId = sensorId;
        this.value = value;
    }
}
