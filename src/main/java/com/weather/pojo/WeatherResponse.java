package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：lqq
 * @ClassName：Data
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse implements Serializable {

    private Weather data;

    private Integer status;

    private String desc;
}
