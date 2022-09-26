package com.project.smartFarm.domain.hydroponics.exception;

import com.project.smartFarm.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DeviceAndTypeNotFoundException extends BusinessException {
    public DeviceAndTypeNotFoundException() {
        super(HttpStatus.NOT_FOUND, "기기 또는 센서 종류를 찾을 수 없습니다");
    }
}
