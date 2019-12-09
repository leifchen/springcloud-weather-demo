package com.chen.weather.report.service.impl;

import com.chen.weather.report.service.WeatherDataClient;
import com.chen.weather.report.service.WeatherReportService;
import com.chen.weather.report.vo.Weather;
import com.chen.weather.report.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 天气预报服务的实现类
 * <p>
 * @Author LeifChen
 * @Date 2019/12/5
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        // 由天气数据 API 微服务来提供
        WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
        Weather data = resp.getData();
        return data;
    }
}
