package com.weather.job;

import com.weather.pojo.City;
import com.weather.pojo.County;
import com.weather.service.WeatherService;
import com.weather.service.XmlToPojoService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.function.Consumer;

/**
 * @Author：lqq
 * @ClassName：WeatherQuartz
 * @Time：2020/3/1
 * @Describe：定时任务
 */
@Slf4j
public class WeatherQuartz extends QuartzJobBean {

    @Autowired
    private XmlToPojoService xmlToPojoService;
    @Autowired
    private WeatherService weatherService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("weather data sync start");
        //获取城市列表
        List<County> counties = null;
        try {
            counties = xmlToPojoService.chinaList();
            System.out.println("_________"+counties);
        } catch (Exception e) {
            log.error("error = {}", e);
        }
        //遍历城市ID获取天气
        for (County county : counties) {
            String weatherCode = county.getWeatherCode();
            log.info("【weatherCode】 weatherCode = {}",weatherCode);
            weatherService.syncByCityId(weatherCode);
        }
        log.info("weather data sync end");
    }
}
