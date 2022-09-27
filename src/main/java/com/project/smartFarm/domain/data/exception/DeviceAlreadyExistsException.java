package com.project.smartFarm.domain.data.exception;

import com.project.smartFarm.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DeviceAlreadyExistsException extends BusinessException {
    public DeviceAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "등록된 기기입니다");
    }
}
