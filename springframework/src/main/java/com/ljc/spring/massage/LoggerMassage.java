package com.ljc.spring.massage;

import javax.management.RuntimeErrorException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerMassage {
	
	
	@AfterThrowing(value="execution(public * com.ljc.spring.server.CalculatorServer.add(..))",throwing = "exception")
	public void addInfo3(JoinPoint joinPoint,Exception exception){
		
		System.out.println("来来来：——"+joinPoint.getArgs()+"enenen"+exception);
	}
	
	public void addInfo4(JoinPoint joinPoint,Exception exception){
			
			System.out.println("来来来：——"+joinPoint.getArgs()+"enenen"+exception);
		}
	
	@Before(value="point()")
	public void addInfo1(JoinPoint joinPoint){
		
		System.out.println("来来来：——"+joinPoint.getArgs());
	}
	
	
	public void addInfo2(JoinPoint joinPoint){
			
			System.out.println("来来来：——"+joinPoint.getArgs());
		}
	
	@Pointcut(value="execution(public * com.ljc.spring.server.CalculatorServer.add(..))")
	public void point() {
	}
	/**
	 * 
	 * @param ProceedingJoinPoint
	 * 	环绕通知
	 */
	@Around(value = "point()")
	public Object myAroud(ProceedingJoinPoint pjp) {
		Object[] args = pjp.getArgs();
		Object proceed = null;
		try {
			//利用反射调用目标方法，它就是method.invoke()
			proceed = pjp.proceed(args);
			System.out.println("pjp.proceed()"+proceed);
		} catch (Throwable e) {
			System.out.println("myAroud异常信息"+e);
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			System.out.println("myAroud"+proceed);
		}
		System.out.println("=============================="+proceed);
		return proceed;
	}

}
