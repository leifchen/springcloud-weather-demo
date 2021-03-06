package com.chen.weather.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 天气收集微服务
 * <p>
 * @Author LeifChen
 * @Date 2019-12-06
 */
@EnableFeignClients
@EnableDiscoveryClient
@EnableScheduling
@SpringBootApplication
public class WeatherCollectionApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionApp.class, args);
    }
}
