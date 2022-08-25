package com.project.smartFarm.iot.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class IotSocket {

    private static TcpServerProperties properties;

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(8082);

            while(true) {
                Socket socket = ss.accept();

                log.info("[" + socket.getInetAddress() + "] Client Connected");
            }
        } catch (IOException e) {
            System.out.println("Server Exception : " + e.getMessage());
            e.printStackTrace();
        }

    }

}
