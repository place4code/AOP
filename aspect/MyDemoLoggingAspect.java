package com.place4code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.place4code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("execution(* com.place4code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void noSetterGetter(JoinPoint point) {
		System.out.println("\n-> @Before My Logging <- \n");
		
		//display the method signature
		String signature = point.getSignature().toShortString();
		
		//display method arguments
		System.out.println("@Before Method: " + signature);
		
		//display method arguments
		
		//get arguments
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
	
	
	//add a new advice for @Afterreturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.place4code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturning(JoinPoint point, List<Account> result) {
		
		//print witch method
		String method = point.getSignature().toShortString();
		System.out.println("-> @AfterReturning on method: " + method);
		
		//print results
		System.out.println("-> Result: " + result);
		
		result.get(0).setName("AfterReturning mod");
		
	}
	
	//add a new advice for @Afterreturning on the findAccounts method
	@After("execution(* com.place4code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void after(JoinPoint point) {
			
		//print witch method
		String method = point.getSignature().toShortString();
		System.out.println("-> @After on method: " + method);

	}
		
	@Around("execution(* com.place4code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		
		//try-catch because Exception handling
		try {
			
			//get begin
			long begin = System.currentTimeMillis();
			
			//execute the method - call the target method
			Object result = point.proceed();
			
			//come back and get end time
			long end = System.currentTimeMillis();
			
			//show duration
			System.out.println("Duration: " + (end - begin));
			
			//result method... as object
			return result;
			
		} catch(Exception e) {
			//exception handling
			//...
			System.out.println(e.getMessage());
			
			//rethrow exception to main
			throw e;
		}
		
	}
	
	
	
	
	
	
	
}
