package com.salemalawi.springkafkastreamfunction.events;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class ConfigEvetn {


    @Bean
    public Consumer<String> sinkEventChanel() {
        return (message) -> {

            System.out.println("################");
            System.out.println(message);
            System.out.println("################");

        };
    }

    @Bean
    public Function<String, String> simpleProcessEvent() {

        return (message) -> {

            System.out.println("###");
            System.out.println("received Message that need to process");
            System.out.println("processing message now");
            message = message.toUpperCase();
//            message.foreach((key, value) -> {
//                System.out.println("Key: " + key + " Value: " + value);
//            });
            System.out.println("finish processing Message and start exporting to simple simpleTopic");
            System.out.println("###");
            return message;
        };
    }


}
