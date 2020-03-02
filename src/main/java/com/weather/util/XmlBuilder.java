package com.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Author：lqq
 * @ClassName：XmlBuilder
 * @Time：2020/3/1
 * @Describe：xml转换构建工具
 */
public class XmlBuilder {

    /**
     * 将xml文件转换成pojo文件
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject = null;

        Reader reader = null;

        JAXBContext context = JAXBContext.newInstance(clazz);
        //XML转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader)
            reader.close();

        return xmlObject;
    }
}
