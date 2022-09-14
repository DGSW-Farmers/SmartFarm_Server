package com.project.smartFarm.global.exception;

import org.springframework.http.HttpStatus;

public class DeviceAlreadyExistsException extends BusinessException{

    public static final DeviceAlreadyExistsException EXCEPTION = new DeviceAlreadyExistsException();

    private DeviceAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "이미 등록된 기기입니다");
    }
}
