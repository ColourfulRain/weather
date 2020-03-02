package com.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author：lqq
 * @ClassName：China
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "China")
@XmlAccessorType(XmlAccessType.FIELD)
public class China {

    @XmlElement(name = "province")
    private List<Province> provinceList;
}
