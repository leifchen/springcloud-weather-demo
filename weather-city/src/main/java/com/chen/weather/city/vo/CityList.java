package com.chen.weather.city.vo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 城市列表
 * <p>
 * @Author LeifChen
 * @Date 2019-12-05
 */
@Getter
@Setter
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

	@XmlElement(name = "d")
	private List<City> cityList;
}
