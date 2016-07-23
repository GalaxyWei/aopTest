package holiday.aopTest.xml;

import com.thoughtworks.xstream.XStream;

/**
 * @Author: xuwei.shen
 * @Date: 2016/7/23
 * @Time: 18:02
 * Copyright (c) 2016, sxwpower@outlook.com All Rights Reserved.
 */
public class XmlUtil {

    public static <T> String beanToXml(T bean ,Class ... classes)
    {
        XStream stream = new XStream();
        stream.processAnnotations(classes);
        String xml = stream.toXML(bean);
        return xml;
    }
}
