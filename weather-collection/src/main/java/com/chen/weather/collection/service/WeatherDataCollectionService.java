package com.chen.weather.collection.service;

/**
 * 天气数据收集服务接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID来同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
