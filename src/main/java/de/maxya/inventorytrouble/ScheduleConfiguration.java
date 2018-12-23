package de.maxya.inventorytrouble;

import de.maxya.inventorytrouble.control.schedule.RblParserSchedule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    @Bean
    public RblParserSchedule checkFreePlaces(){
        return new RblParserSchedule();
    }
}
