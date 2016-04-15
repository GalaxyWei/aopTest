/**  
 * Project Name:aopTest  
 * File Name:ReadProperties.java  
 * Package Name:holiday.aopTest.util  
 * Date:2015年6月30日下午4:51:52  
 * Copyright (c) 2015, sxw1989@126.com All Rights Reserved.  
 *  
*/  
  
package holiday.aopTest.util;  

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;


/**  
 * ClassName:ReadProperties <br/>  
 * Function: 读取配置文件. <br/>  
 * Date:     2015年6月30日 下午4:51:52 <br/>  
 * @author   lenovo  
 * @version  1.0
 * @since    JDK 1.7 
 */
public class ReadProperties {
	
	private volatile static Properties properties = null;
	
	public static Object read(String paths,String key)
	{
		if(properties == null)
		{
			synchronized (ReadProperties.class) {
				if(properties == null)
				{
					properties = new Properties();
					String[] path = paths.split("\\;");
					if(path.length > 0)
					{
						for(String item :path)
						{
							try {
								properties.putAll(PropertiesLoaderUtils.loadAllProperties(item));
							} catch (IOException e) {
								  
								// TODO Auto-generated catch block  
								e.printStackTrace();  
								
							};
						}
					}
				}
				
			}
		}
		return properties.getProperty(key);
	}
}
  
