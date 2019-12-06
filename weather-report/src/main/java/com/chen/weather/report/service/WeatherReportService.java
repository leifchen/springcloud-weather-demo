package com.chen.weather.report.service;

import com.chen.weather.report.vo.Weather;

/**
 * 天气预报服务接口
 * <p>
 * @Author LeifChen
 * @Date 2019/12/5
 */
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
