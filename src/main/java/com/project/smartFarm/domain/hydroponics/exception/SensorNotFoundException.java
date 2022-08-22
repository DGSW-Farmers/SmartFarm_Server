package com.project.smartFarm.domain.hydroponics.exception;

import com.project.smartFarm.global.exception.BusinessException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SensorNotFoundException extends BusinessException {

    public final static SensorNotFoundException EXCEPTION = new SensorNotFoundException();

    private SensorNotFoundException() {
        super(HttpStatus.NOT_FOUND, "센서를 찾을 수 없습니다");
    }
}
