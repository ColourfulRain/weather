package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：Province
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "province")
@XmlAccessorType(XmlAccessType.FIELD)
public class Province {

    @XmlAttribute(name = "id")
    private String provinceId;

    @XmlAttribute(name = "name")
    private String provinceName;

    @XmlElement(name = "city")
    private List<City> cityList;
}
