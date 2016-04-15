/**  
 * Project Name:aopTest  
 * File Name:SpringProperties.java  
 * Package Name:holiday.aopTest.util  
 * Date:2015年6月30日下午5:44:59  
 * Copyright (c) 2015, sxw1989@126.com All Rights Reserved.  
 *  
*/  
  
package holiday.aopTest.util;  

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**  
 * ClassName:SpringProperties <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2015年6月30日 下午5:44:59 <br/>  
 * @author   lenovo  
 * @version  1.0
 * @since    JDK 1.7 
 */
public class SpringProperties {
	
	private final static String APPLICATIONCONTEXT = "classpath:config/applicationContext.xml";

	private volatile static ApplicationContext context = null;
	
	public static Object getBean(String name)
	{
		if(context == null)
		{
			synchronized (SpringProperties.class) {
				if(context == null)
				{
					context = new ClassPathXmlApplicationContext(APPLICATIONCONTEXT);
				}
			}
		}
		return context.getBean(name);
	}
}
  
