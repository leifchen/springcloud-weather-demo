package com.chen.weather.vo;

import lombok.Data;

/**
 * WeatherResponse
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
@Data
public class WeatherResponse {

    private Weather data;
    private Integer status;
    private String desc;
}
