package com.chen.weather.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 天气预报微服务
 * <p>
 * @Author LeifChen
 * @Date 2019-12-06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WeatherReportApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherReportApp.class, args);
    }
}