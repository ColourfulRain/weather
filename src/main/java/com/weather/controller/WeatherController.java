package com.weather.controller;

import com.weather.pojo.WeatherResponse;
import com.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：lqq
 * @ClassName：WeatherController
 * @Time：2020/3/1
 * @Describe：
 */
@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getCityId(@PathVariable("cityId") String cityId) {
        log.info("【weather】cityId = {}",cityId);
        WeatherResponse cityIdValue = weatherService.getCityId(cityId);
        log.info("【weather】cityIdValue = {}",cityIdValue);
        return cityIdValue;
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getCityName(@PathVariable("cityName") String cityName) {
        log.info("【weather】cityName = {}",cityName);
        WeatherResponse cityNameValue = weatherService.getCityName(cityName);
        log.info("【weather】cityNameValue = {}",cityName);
        return cityNameValue;
    }
}
