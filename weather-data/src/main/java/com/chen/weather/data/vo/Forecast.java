package com.chen.weather.data.vo;

import lombok.Data;

/**
 * 未来天气
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
@Data
public class Forecast {

	private String date;
	private String high;
	private String fengli;
	private String low;
	private String fengxiang;
	private String type;
}
