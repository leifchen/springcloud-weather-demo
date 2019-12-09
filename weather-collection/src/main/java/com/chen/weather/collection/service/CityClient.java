package com.chen.weather.collection.service;

import com.chen.weather.collection.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 城市数据API接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-09
 */
@FeignClient(name = "weather-city")
public interface CityClient {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
