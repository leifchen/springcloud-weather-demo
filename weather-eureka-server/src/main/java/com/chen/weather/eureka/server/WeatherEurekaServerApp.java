package com.chen.weather.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 天气项目的Eureka服务注册中心
 * <p>
 * @Author LeifChen
 * @Date 2019-12-06
 */
@EnableEurekaServer
@SpringBootApplication
public class WeatherEurekaServerApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherEurekaServerApp.class, args);
    }
}
