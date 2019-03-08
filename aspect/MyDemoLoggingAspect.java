package com.place4code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(* addAccount())") // = public void addAccount()
	@Before("execution(* com.place4code.aopdemo.dao.AccountDAO.add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n-> Executing @Before advice on addAccount() \n");
	}
	
}
