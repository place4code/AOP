package com.place4code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.place4code.aopdemo.aspect.AopAspects.withoutSettersGetter()")
	public void noSetterGetter() {
		System.out.println("\n-> My Logging <- \n");
	}
	
}
