/**  
 * Project Name:aopTest  
 * File Name:StringService.java  
 * Package Name:holiday.aopTest.service  
 * Date:2015年6月30日下午1:58:08  
 * Copyright (c) 2015, sxw1989@126.com All Rights Reserved.  
 *  
*/  
  
package holiday.aopTest.service;  

import java.util.Map;

import holiday.aopTest.base.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**  
 * ClassName:StringService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2015年6月30日 下午1:58:08 <br/>  
 * @author   lenovo  
 * @version  1.0
 * @since    JDK 1.7 
 */
@Service(value = "stringService")
public class StringService extends BaseService {
	
	@Autowired
	private BaseService baseService;
	
	// 切入点
    public String delete(String obj,String args) {
        System.out.println("==========调用切入点：" + obj + "说：你敢删除我！===========\n");
        return obj + "：瞄～";
    }

    public String add(String obj) {
        System.out.println("================这个方法不能被切。。。============== \n");
        return obj + "：瞄～ 嘿嘿！";
    }

    public String modify(String obj) {
        System.out.println("=================这个也设置加入切吧====================\n");
        return obj + "：瞄改瞄啊！";
    }
    
    public String dd(Map<String, Object> map) {
        System.out.println("=================这个也设置加入切吧====================\n");
        return map + "：瞄改瞄啊！";
    }
}
  
