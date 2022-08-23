package com.project.smartFarm.iot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("tcp.server")
@Component
@Data
public class TcpServerProperties {

    private int port;

}
