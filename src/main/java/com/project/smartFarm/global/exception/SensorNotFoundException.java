package com.project.smartFarm.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class SensorNotFoundException extends BusinessException {

    public final static SensorNotFoundException EXCEPTION = new SensorNotFoundException();

    private SensorNotFoundException() {
        super(HttpStatus.NOT_FOUND, "센서를 찾을 수 없습니다");
    }
}
