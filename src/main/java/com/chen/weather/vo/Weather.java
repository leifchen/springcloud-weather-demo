package com.chen.weather.vo;

import lombok.Data;

import java.util.List;

/**
 * 天气信息
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
@Data
public class Weather {

	private String city;
	private String aqi;
	private String ganmao;
	private String wendu;
	private Yesterday yesterday;
	private List<Forecast> forecast;
}
