package com.project.smartFarm.global.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Soil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "soil", cascade = {CascadeType.ALL})
    private List<SoilSensorData> soilSensorData;

    @Builder
    public Soil(Long id, String name, List<SoilSensorData> soilSensorData) {
        this.id = id;
        this.name = name;
        this.soilSensorData = soilSensorData;
    }
}
