package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author：lqq
 * @ClassName：Forecast
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast {

    //日期
    private String date;
    //高温
    private String high;
    //风力
    private String fengli;
    //低温
    private String low;
    //风向
    private String fengxiang;
    //多云
    private String type;
}
