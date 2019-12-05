package com.chen.weather.service.impl;

import com.chen.weather.service.CityDataService;
import com.chen.weather.util.XmlUtils;
import com.chen.weather.vo.City;
import com.chen.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 城市数据服务实现类
 * <p>
 * @Author LeifChen
 * @Date 2019-12-05
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() throws Exception {
        // 读取XML文件
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder buffer = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            buffer.append(line);
        }

        br.close();

        // XML转为Java对象
        CityList cityList = (CityList) XmlUtils.xml2Oject(CityList.class, buffer.toString());
        return cityList.getCityList();
    }
}
