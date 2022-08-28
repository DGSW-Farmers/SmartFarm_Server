package com.project.smartFarm.domain.hydroponics.exception;

import com.project.smartFarm.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class SensorDataTransferFailedException extends BusinessException {

    public static final SensorDataTransferFailedException EXCEPTION = new SensorDataTransferFailedException();

    private SensorDataTransferFailedException() {
        super(HttpStatus.BAD_REQUEST, "다른 서버에 전송을 실패하였습니다");
    }
}
