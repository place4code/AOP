package com.place4code.aopdemo;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.place4code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	//new feature
	private static Logger logger = Logger.getLogger(AfterReturningDemoApp.class.getName());
			
			
	public static void main(String[] args) {

		
		//read spring configuration
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = accountDAO.findAccounts();
		
		//display accounts with streams:
		
		List<Account> stream = accounts.stream().collect(Collectors.toList());
		stream.forEach(System.out::println);
		
		logger.info("test");
		
		//close spring context
		context.close();
		
	}

}
