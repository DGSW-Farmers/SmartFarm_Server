package com.project.smartFarm.global.entity;

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

    private String name;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<HydroponicsSensorData> sensorData;

    @Builder
    public Hydroponics(Long id, String name, List<HydroponicsSensorData> sensorData) {
        this.id = id;
        this.name = name;
        this.sensorData = sensorData;
    }
}
