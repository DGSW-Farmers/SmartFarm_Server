package com.project.smartFarm.iot.config;

import com.project.smartFarm.iot.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
@RequiredArgsConstructor
public class TcpServerEndPoint {

    private final MessageService messageService;

    @ServiceActivator(inputChannel = "inboundChannel", async = "true")
    public byte[] process(byte[] message) {
        return messageService.processMessage(message);
    }

}
