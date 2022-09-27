package com.project.smartFarm.domain.data.entity;

import com.project.smartFarm.domain.data.type.SensorType;
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

    @Enumerated(EnumType.STRING)
    private SensorType type;

    private String value;

    @CreationTimestamp
    private LocalDateTime saveDate;

}
