package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author：lqq
 * @ClassName：Yesterday
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yesterday implements Serializable {

    //日期
    private String date;
    //高温
    private String high;
    //风向
    private String fx;
    //低温
    private String low;
    //风力
    private String fl;
    //多云
    private String type;
}
