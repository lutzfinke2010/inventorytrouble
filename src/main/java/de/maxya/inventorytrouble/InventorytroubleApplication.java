package de.maxya.inventorytrouble;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;

@SpringBootApplication
@ComponentScan(basePackages = {"de.maxya.inventorytrouble",
        "de.maxya.inventorytrouble.boundary",
        "de.maxya.inventorytrouble.control",
        "de.maxya.inventorytrouble.entity.repository"})
public class InventorytroubleApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventorytroubleApplication.class, args);
    }



}
