package com.chen.weather.collection.task;

import com.chen.weather.collection.service.CityClient;
import com.chen.weather.collection.service.WeatherDataCollectionService;
import com.chen.weather.collection.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气预报数据定时同步任务
 * <p>
 * @Author LeifChen
 * @Date 2019-12-05
 */
@Slf4j
@Component
public class WeatherDataSyncTask {

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;
    @Autowired
    private CityClient cityClient;

    @Scheduled(cron = "${weather.quartz.refresh:0 0 0/1 * * ?}")
    public void execute() {
        log.info("Weather Data Sync Task. Start！");
        // 获取城市ID列表
        List<City> cityList = new ArrayList<>();

        // 由城市数据 API 微服务提供数据
        try {
            cityList = cityClient.listCity();
        } catch (Exception e) {
            log.error("获取城市列表失败！", e);
        }

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Task, cityId:" + cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        log.info("Weather Data Sync Task. End！");
    }
}
