package com.weather.service;

import com.weather.pojo.China;
import com.weather.pojo.County;

import java.util.List;

/**
 * @Author：lqq
 * @ClassName：XmlToPojoService
 * @Time：2020/3/1
 * @Describe：
 */
public interface XmlToPojoService {

    List<County> chinaList() throws Exception;
}
