package com.place4code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopAspects {

			//@Pointcut for getter
			@Pointcut("execution(* com.place4code.aopdemo.dao.*.get*(..))")
			public void getter() {}
			
			//@Pointcut for setter
			@Pointcut("execution(* com.place4code.aopdemo.dao.*.set*(..))")
			public void setter() {}
			
			
			@Pointcut("execution(* com.place4code.aopdemo.dao.*.*(..))")
			public void forDaoPackages() {}
			
			
			//create @Pointcut: include package, exclude getters/setters
			@Pointcut("forDaoPackages() && !(getter() || setter())")
			public void withoutSettersGetter() {}
			
}
