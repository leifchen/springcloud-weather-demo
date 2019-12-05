package com.chen.weather.service.impl;

import com.chen.weather.service.WeatherDataService;
import com.chen.weather.vo.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 天气预报数据服务实现类
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final int SUCCESS = 200;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return doGetWeather(uri);
    }

    /**
     * 获取天气预报数据
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = "";

        if (respString.getStatusCodeValue() == SUCCESS) {
            strBody = respString.getBody();
        }

        if (StringUtils.isNotBlank(strBody)) {
            try {
                resp = mapper.readValue(strBody, WeatherResponse.class);
            } catch (JsonProcessingException e) {
                log.error("解析失败！", e);
            }
        }

        return resp;
    }

    @Override
    public void syncDataByCityId(String cityId) {
        //todo 调用 API 接口，并把返回的数据缓存到 Redis
    }
}
