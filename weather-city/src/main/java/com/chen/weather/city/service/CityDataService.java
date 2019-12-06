package com.chen.weather.city.service;

import com.chen.weather.city.vo.City;

import java.util.List;

/**
 * 城市数据服务接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-05
 */
public interface CityDataService {

	/**
	 * 获取城市列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
