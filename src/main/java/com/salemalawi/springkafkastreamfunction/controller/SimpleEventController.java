package com.salemalawi.springkafkastreamfunction.controller;

import com.salemalawi.springkafkastreamfunction.service.SimpleEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleEventController {

    @Autowired
    private SimpleEventService simpleEventService;

    private final static String MESSAGE = "check console logs";


    @GetMapping("")
    public String homeController(@RequestParam(value = "message",defaultValue = "Hello World")String message) {

        this.simpleEventService.sendToSimpleTopic(message);

        return MESSAGE;
    }

    @GetMapping("/to-uppercase")
    public String processToUperCase(@RequestParam(value = "message",defaultValue = "Hello World")String message){

        this.simpleEventService.sendToUpperCaseProcess(message);

        return MESSAGE;


    }




}
