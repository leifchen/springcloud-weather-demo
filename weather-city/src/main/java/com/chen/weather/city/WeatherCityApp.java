package com.chen.weather.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 城市数据API微服务
 * <p>
 * @Author LeifChen
 * @Date 2019-12-06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class WeatherCityApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCityApp.class, args);
    }
}
