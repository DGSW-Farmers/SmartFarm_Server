package com.project.smartFarm.domain.data.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Builder
@AllArgsConstructor
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Device {

    @Id
    private int deviceId;

    private String name;

    @CreationTimestamp
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SensorData> dataList;
    public void addData(SensorData data) {
        data.setDevice(this);
        this.dataList.add(data);
    }

    public void termiteDevice() {
        this.endDate = LocalDateTime.now();
    }

}
