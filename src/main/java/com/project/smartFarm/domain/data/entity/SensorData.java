package com.project.smartFarm.domain.data.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Builder
@AllArgsConstructor
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    public void setDevice(Device device) {
        this.device = device;
    }

    private String temperature;
    private String humidity;
    private String led;
    private String pan;
    private String sunlight;
    private String pump;
    private String liquid;
    private String waterLevel;

    @CreationTimestamp
    private LocalDateTime saveDate;

}
