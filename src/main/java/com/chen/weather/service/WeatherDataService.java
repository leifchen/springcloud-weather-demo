package com.chen.weather.service;

import com.chen.weather.vo.WeatherResponse;

/**
 * 天气预报数据服务接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
