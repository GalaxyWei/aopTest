/**  
 * Project Name:aopTest  
 * File Name:AopBeforeTest.java  
 * Package Name:holiday.aopTest  
 * Date:2015年6月30日下午5:44:05  
 * Copyright (c) 2015, sxw1989@126.com All Rights Reserved.  
 *  
*/  
  
package holiday.aopTest;  

import java.util.HashMap;
import java.util.Map;

import holiday.aopTest.service.StringService;
import holiday.aopTest.util.SpringProperties;

/**  
 * ClassName:AopBeforeTest <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2015年6月30日 下午5:44:05 <br/>  
 * @author   lenovo  
 * @version  1.0
 * @since    JDK 1.7 
 */
public class AopBeforeTest {

	public static void main(String[] args) {

		StringService stringService = (StringService)SpringProperties.getBean("stringService");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", "沈徐伟");
		map.put("ddd", "dfafafa");
		stringService.dd(map);
//        stringService.delete("","");
	}
}
  
