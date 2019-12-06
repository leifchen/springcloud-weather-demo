package com.chen.weather.data.service.impl;

import com.chen.weather.data.service.WeatherDataService;
import com.chen.weather.data.vo.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    /**
     * 获取天气预报数据
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {
        String strBody;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(uri)) {
            log.info("Redis has data");
            strBody = ops.get(uri);
        } else {
            log.info("Redis don't has data");
            // 缓存没有，抛出异常
            throw new RuntimeException("Redis don't has data!");
        }

        if (StringUtils.isNotBlank(strBody)) {
            try {
                resp = mapper.readValue(strBody, WeatherResponse.class);
            } catch (JsonProcessingException e) {
                log.error("天气数据JSON解析失败!", e);
            }
        }

        return resp;
    }
}
