package com.chen.weather.report.service;

import com.chen.weather.report.vo.City;
import com.chen.weather.report.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 数据服务API的熔断服务
 * <p>
 * @Author LeifChen
 * @Date 2019-12-10
 */
@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() {
        return Collections.emptyList();
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
