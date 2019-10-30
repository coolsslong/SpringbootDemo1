package com.ssl.springboot2task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     * second as well as minute, hour, day of month, month and day of week.
     * 秒，分，时，日，月，周几
     * E.g. {@code "0 * * * * MON-FRI"}
     */
    @Scheduled(cron = "0 38 15 19 * ?")
    public void hello() {
        System.out.println("Hello");
    }
}
