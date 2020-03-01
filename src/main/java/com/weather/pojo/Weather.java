package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：Weather
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather implements Serializable {

    private Yesterday yesterday;

    private String city;

    private List<Forecast> forecast;

    private String ganmao;

    private String wendu;
}
