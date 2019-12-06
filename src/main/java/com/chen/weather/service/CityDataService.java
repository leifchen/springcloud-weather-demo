package com.chen.weather.service;

import com.chen.weather.vo.City;

import java.util.List;

/**
 * 城市数据服务接口
 * <p>
 * @Author LeifChen
 * @Date 2019-12-05
 */
public interface CityDataService {

	/**
	 * 获取City列表
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
