package com.project.smartFarm.domain.data.exception;

import com.project.smartFarm.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DeviceNotFoundException extends BusinessException {
    public DeviceNotFoundException() {
        super(HttpStatus.NOT_FOUND, "기기를 찾을 수 없습니다");
    }
}
