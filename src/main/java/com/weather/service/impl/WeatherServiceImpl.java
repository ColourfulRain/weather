package com.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.pojo.WeatherResponse;
import com.weather.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author：lqq
 * @ClassName：WeatherServiceImpl
 * @Time：2020/3/1
 * @Describe：
 */
@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getCityId(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        return getDate(url);
    }

    @Override
    public WeatherResponse getCityName(String cityName) {
        String url = WEATHER_URL + "city=" + cityName;
        return getDate(url);
    }

    private WeatherResponse getDate(String url) {
        String str = null;
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse v = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(url)) {
            log.info("【weatherServiceImpl】 {}", "redis hit");
            str = ops.get(url);
        } else {
            log.info("【weatherServiceImpl】 {}", "redis not hit");
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            //类型转换
            if (forEntity.getStatusCodeValue() == 200) {
                str = forEntity.getBody();
            }
            //添加到缓存中
            ops.set(url, str, 1800, TimeUnit.SECONDS);
        }
        try {
            v = objectMapper.readValue(str, WeatherResponse.class);
        } catch (IOException e) {
            log.error("【getDate】error = {}", e);
        }
        return v;
    }

    @Override
    public void syncByCityId(String cityId) {
        String url = WEATHER_URL + "citykey=" + cityId;
        this.saveWeatherData(url);
    }

    private void saveWeatherData(String url) {

        String strBody = null;
        ValueOperations<String, String> ssl = stringRedisTemplate.opsForValue();
        //缓存没有，在调用服务接口来获取
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        if (forEntity.getStatusCodeValue() == 200){
            strBody = forEntity.getBody();
        }
        ssl.set(url,strBody,1800, TimeUnit.SECONDS);
    }
}
