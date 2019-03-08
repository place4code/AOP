package com.place4code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.place4code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method
		accountDAO.addAccount();
		
		//close spring context
		context.close();
		
	}

}
