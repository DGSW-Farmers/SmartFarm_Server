package com.project.smartFarm.domain.hydroponics.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hydroponics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int deviceId;

    @OneToMany(mappedBy = "device", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<HydroponicsSensorData> sensorDataList;
    public void addSensorData(HydroponicsSensorData data) {
        this.sensorDataList.add(data);
    }

    @Builder
    public Hydroponics(int deviceId) {
        this.deviceId = deviceId;
    }
}
