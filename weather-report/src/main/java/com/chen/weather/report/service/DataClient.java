package com.chen.weather.report.service;

import com.chen.weather.report.vo.City;
import com.chen.weather.report.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 数据服务API接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-09
 */
@FeignClient(name = "weather-gateway")
public interface DataClient {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市ID查询天气数据
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
