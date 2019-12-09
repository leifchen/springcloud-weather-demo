package com.chen.weather.report.service;

import com.chen.weather.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 天气数据API接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-09
 */
@FeignClient(name = "weather-data")
public interface WeatherDataClient {

    /**
     * 根据城市ID获取天气数据
     * @param cityId
     * @return
     */
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
