package com.chen.weather.vo;

import lombok.Data;

/**
 * 昨日天气
 * <p>
 * @Author LeifChen
 * @Date 2019-12-04
 */
@Data
public class Yesterday {
	
	private String date;
	private String high;
	private String fx;
	private String low;
	private String fl;
	private String type;
}
