package com.learning.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect //its a container where we hold all our aop code
public class UserServiceAspect {
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(@org.springframework.stereotype.Repository *) "+
	"|| within(@org.springframework.stereotype.Service *) "+
	"|| within(@org.springframework.web.bind.annotation.RestController *) ")
	
	public void springPointCutExp() {
		
	}
	
	@Pointcut("within(com.learning.controller..*) "+
			"|| within(com.learning.service.Impl..*) ")
			
	public void springPointCutExp2() {
				
	}
	
	@AfterThrowing(pointcut = "springPointCutExp() && springPointCutExp2()", throwing = "e")
	public void logAfterThrowingException(JoinPoint joinPoint, Throwable e){
		log.error("exception {}.{}() with cause {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), e.getCause()!=null ? e.getCause():"NULL");
	}
	

	
	@Before(value = "execution(* com.learning.service.Impl.*.get*(..))")
	public void beforeAllServiceMethods(JoinPoint joinPoint) {
		//action - advice
		System.out.println("before hello");
		System.out.println(joinPoint.getTarget());
	}
	
//	@After(value = "execution(* com.zee.zee5app.service.impl.*.*(..))")
//	public void afterAllServiceMethods(JoinPoint joinPoint) {
//		System.out.println("thanks");
//		System.out.println(joinPoint);
//	}
	


}