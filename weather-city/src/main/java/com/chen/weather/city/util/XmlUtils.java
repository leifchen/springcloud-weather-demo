package com.chen.weather.city.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * XML工具类
 * <p>
 * @Author LeifChen
 * @Date 2019-12-05
 */
public class XmlUtils {

	/**
	 * 将XML转为指定的POJO
	 * @param clazz
	 * @param xmlStr
	 * @return
	 * @throws Exception
	 */
	public static Object xml2Oject(Class<?> clazz, String xmlStr) throws Exception {
		Object xmlObject;
		Reader reader;
		JAXBContext context = JAXBContext.newInstance(clazz);

		// XML 转为对象的接口
		Unmarshaller unmarshaller = context.createUnmarshaller();

		reader = new StringReader(xmlStr);
		xmlObject = unmarshaller.unmarshal(reader);
		if (null != reader) {
			reader.close();
		}

		return xmlObject;
	}
}
