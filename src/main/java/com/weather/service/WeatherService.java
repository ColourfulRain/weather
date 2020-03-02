package com.weather.service;

import com.weather.pojo.WeatherResponse;

import javax.lang.model.element.VariableElement;

/**
 * @Author：lqq
 * @ClassName：WeatherService
 * @Time：2020/3/1
 * @Describe：
 */
public interface WeatherService {

    /**
     * 根据cityId查询
     * @param cityId
     * @return
     */
    WeatherResponse getCityId(String cityId);

    /**
     * 根据cityName查询
     * @param cityName
     * @return
     */
    WeatherResponse getCityName(String cityName);

    /**
     * 根据城市id进行同步
     * @param cityId
     */
    void syncByCityId(String cityId);
}
