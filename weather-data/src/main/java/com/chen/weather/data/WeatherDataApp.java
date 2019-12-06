package com.chen.weather.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 天气数据API微服务
 * <p>
 * @Author LeifChen
 * @Date 2019-12-06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WeatherDataApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataApp.class, args);
    }
}
