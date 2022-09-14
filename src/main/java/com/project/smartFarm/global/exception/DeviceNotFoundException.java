package com.project.smartFarm.global.exception;

import org.springframework.http.HttpStatus;

public class DeviceNotFoundException extends BusinessException{

    public final static DeviceNotFoundException EXCEPTION = new DeviceNotFoundException();

    private DeviceNotFoundException() {
        super(HttpStatus.NOT_FOUND, "디바이스를 찾을수 없습니다");
    }

}
