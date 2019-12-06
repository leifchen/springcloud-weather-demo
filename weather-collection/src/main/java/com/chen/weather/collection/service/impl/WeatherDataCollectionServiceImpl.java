package com.chen.weather.collection.service.impl;

import com.chen.weather.collection.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 天气预报数据服务实现类
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
@Slf4j
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final int SUCCESS = 200;
    private static final long TIME_OUT = 10L;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String strBody = "";

        // 调用服务接口来获取
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCodeValue() == SUCCESS) {
            strBody = respString.getBody();
        }

        // 数据写入Redis缓存
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
