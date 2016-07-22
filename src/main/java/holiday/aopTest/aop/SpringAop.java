/**  
 * Project Name:aopTest  
 * File Name:SpringAop.java  
 * Package Name:holiday.aopTest.aop  
 * Date:2015年6月30日下午1:51:42  
 * Copyright (c) 2015, sxw1989@126.com All Rights Reserved.  
 *  
*/  
  
package holiday.aopTest.aop;  

import java.util.Map;

import holiday.aopTest.common.JoinPointConst;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**  
 * ClassName:SpringAop <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2015年6月30日 下午1:51:42 <br/>  
 * @author   lenovo  
 * @version  1.0
 * @since    JDK 1.7 
 */
@Aspect
@Component
public class SpringAop {
	
	private final static Logger log = Logger.getLogger(SpringAop.class);
	
	@Pointcut(JoinPointConst.PARAMTER_POINT)
	public void anyMetho(){}
	
	@Before(value = "execution(* holiday.aopTest.service.StringService.dd(..)) || execution(* holiday.aopTest.service.StringService.delete(..))")
	public Object checkBefore(JoinPoint joinPoint ) throws Exception
	{
		System.out.println("===========进入before advice============ \n");

        System.out.println("准备在" + joinPoint.getTarget().getClass() + "对象上用");
        System.out.println("method:" + ((MethodSignature)joinPoint.getSignature()).getName());
        Class<?>[] params = ((MethodSignature)joinPoint.getSignature()).getMethod().getParameterTypes();
        for (Class<?> param : params) {
            System.out.println("====" + param.getName());
        }
        System.out.println(joinPoint.getSignature().getName() + "方法进行对 '");
        System.out.println(joinPoint.getArgs()[0] + "'进行删除！\n\n");
        Map<String, Object> map = (Map<String, Object>)joinPoint.getArgs()[0];
        System.out.println(map);
        map.put("test", "*" + String.valueOf(map.get("test")).substring(1, String.valueOf(map.get("test")).length()));
		throw new Exception("AOP测试");
	}
	
//	@AfterReturning(value = "execution(* holiday.aopTest.service.StringService.*(..))",returning = "result")
//	@AfterReturning(value = "within(holiday.aopTest.service..*)" ,returning = "result")
//	public void doAfter(JoinPoint jp, String result) {
//        System.out.println("==========进入after advice=========== \n");
//        System.out.println("切入点方法执行完了 \n");
//
//        System.out.println(jp.getArgs()[0] + "在");
//        System.out.println(jp.getTarget().getClass() + "对象上被");
//        System.out.println(jp.getSignature().getName() + "方法删除了");
//        System.out.println("只留下：" + result + "\n\n");
//    }
	
//	@Around("execution(* holiday.aopTest.service.StringService.*(..))")
//	@Around(value = "this(holiday.aopTest.service.StringService)")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("===========进入around环绕方法！=========== \n");
//        System.out.println("调用方法之前: 执行！\n");
//        System.out.println("AOP代理对象：" + pjp.getThis());
//        // 调用方法的参数
//        Object[] args = pjp.getArgs();
//        for(Object obj : args)
//        {
//        	if("猫".equals(obj))
//        	{
//        		return "参数是猫，不执行业务代码";
//        	}
//        }
//        // 调用的方法名
//        String method = pjp.getSignature().getName();
//        // 获取目标对象(形如：com.action.admin.LoginAction@1a2467a)
//        Object target = pjp.getTarget();
//       //获取目标对象的类名(形如：com.action.admin.LoginAction)
//        String targetName = pjp.getTarget().getClass().getName();
//        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
//        Object result = pjp.proceed();//result的值就是被拦截方法的返回值
//        System.out.println("连接点类型：" + pjp.getKind());
//        System.out.println("当前连接点签名  :" + pjp.getSignature());
//        System.out.println("连接点方法所在类文件中的位置  :" + pjp.getSourceLocation());
//        System.out.println("输出：参数" + args[0] + ";方法名" + method + ";对象" + target + ";对象名" + targetName + ";返回值"+ result + "\n");
//        System.out.println("调用方法结束：之后执行！\n");
//        return result;
//    }
//	
//	@AfterThrowing(value = "execution(* holiday.aopTest.service.StringService.*(..))", throwing = "e")
//    public void doThrow(JoinPoint jp, Throwable e) {
//        log.error("调用**方法Method=[" + jp.getSignature().getName() + "]异常" , e);
//    }
}
  
