package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：City
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "id")
    private String cityId;
    @XmlAttribute(name = "name")
    private String cityName;
    @XmlElement(name = "county")
    private List<County> countyList;
}
