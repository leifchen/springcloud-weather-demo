package com.chen.weather.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 天气服务网关
 * <p>
 * @Author LeifChen
 * @Date 2019-12-10
 */
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class WeatherGatewayApp {

    public static void main(String[] args) {
        SpringApplication.run(WeatherGatewayApp.class, args);
    }
}
