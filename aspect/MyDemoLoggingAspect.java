package com.place4code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.place4code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.place4code.aopdemo.aspect.AopAspects.withoutSettersGetter()")
	public void noSetterGetter(JoinPoint point) {
		System.out.println("\n-> My Logging <- \n");
		
		//display the method signature
		MethodSignature signature = (MethodSignature) point.getSignature();
		
		//display method arguments
		System.out.println("Method: " + signature);
		
		//display method arguments
		
		//get args
		Object[] args = point.getArgs();
		
		//loop
		for(Object arg: args) {
			System.out.println(arg);
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.println("Account name: " + account.getName());
			}
		}
		
	}
	
}
