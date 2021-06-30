package com.salemalawi.springkafkastreamfunction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class SimpleEventService {

    @Autowired
    private StreamBridge streamBridge;

    public void sendToSimpleTopic(String message) {
        this.streamBridge.send("sourceEventChanel-out-0", message);
    }

    public void sendToUpperCaseProcess(String message) {

        this.streamBridge.send("sourceToProcess-out-0", message);
    }


}
