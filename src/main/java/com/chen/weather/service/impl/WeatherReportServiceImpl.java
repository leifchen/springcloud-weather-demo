package com.chen.weather.service.impl;

import com.chen.weather.service.WeatherDataService;
import com.chen.weather.service.WeatherReportService;
import com.chen.weather.vo.Weather;
import com.chen.weather.vo.WeatherResponse;
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
	private WeatherDataService weatherDataService;
	
	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = weatherDataService.getDataByCityId(cityId);
		return resp.getData();
	}
}
