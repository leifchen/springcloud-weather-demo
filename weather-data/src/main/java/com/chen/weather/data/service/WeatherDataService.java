package com.chen.weather.data.service;

import com.chen.weather.data.vo.WeatherResponse;

/**
 * 天气数据服务接口
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
}
