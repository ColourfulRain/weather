package com.weather.pojo;

import com.sun.xml.internal.txw2.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author：lqq
 * @ClassName：County
 * @Time：2020/3/1
 * @Describe：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "county")
@XmlAccessorType(XmlAccessType.FIELD)
public class County {

    @XmlAttribute(name = "id")
    private String countyId;
    @XmlAttribute(name = "name")
    private String countyName;
    @XmlAttribute(name = "weatherCode")
    private String weatherCode;
}
