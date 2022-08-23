package com.project.smartFarm.iot.service;

import com.project.smartFarm.global.repository.HydroponicsRepository;
import com.project.smartFarm.global.repository.HydroponicsSensorDataRepository;
import com.project.smartFarm.global.repository.SoilRepository;
import com.project.smartFarm.global.repository.SoilSensorDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private static final byte[] DEFAULT_RESPONSE = new byte[0];

    private final SoilRepository soilRepository;
    private final SoilSensorDataRepository soilSensorDataRepository;
    private final HydroponicsRepository hydroponicsRepository;
    private final HydroponicsSensorDataRepository hydroponicsSensorDataRepository;

    // 메세지 읽어서 DEFAULT_RESPONSE 배열에 담기
    public byte[] processMessage(byte[] message) {
        log.info("Receive message : {}", message);

        System.arraycopy(message, 0, DEFAULT_RESPONSE, 0, message.length);

        return DEFAULT_RESPONSE;
    }

    // 받은 데이터를 해석하여 저장
    public void interpretationData() {

    }

    // 데이터베이스에 업데이트
    public void updateSensorData() {



    }

}
