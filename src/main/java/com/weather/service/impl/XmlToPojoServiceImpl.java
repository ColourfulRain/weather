package com.weather.service.impl;

import com.weather.pojo.China;
import com.weather.pojo.City;
import com.weather.pojo.County;
import com.weather.pojo.Province;
import com.weather.service.XmlToPojoService;
import com.weather.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：XmlToPojoServiceImpl
 * @Time：2020/3/1
 * @Describe：
 */
@Service
public class XmlToPojoServiceImpl implements XmlToPojoService{

    public List<County> chinaList() throws Exception {
        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader bf = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer sf = new StringBuffer();
        String line = "";

        while ((line = bf.readLine()) != null) {
            sf.append(line);
        }
        bf.close();
        //将XML文件转换成java对象
        China china = (China) XmlBuilder.xmlStrToObject(China.class,sf.toString());

        List<County> counties = new ArrayList<>();

        for (Province province : china.getProvinceList()) {
            for (City city : province.getCityList()) {
                for (County county : city.getCountyList()) {
                    County county1 = new County();
                    county1.setCountyId(county.getCountyId());
                    county1.setCountyName(county.getCountyName());
                    county1.setWeatherCode(county.getWeatherCode());

                    counties.add(county1);
                }
            }
        }
        return counties;
    }
}
