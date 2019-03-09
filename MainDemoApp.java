package com.place4code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.place4code.aopdemo.dao.AccountDAO;
import com.place4code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		//read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		accountDAO.addAccount(new Account("Test", "Test"));
		accountDAO.setName("test");
		accountDAO.setServiceCode("WF234");
		System.out.println(accountDAO.getName());
		System.out.println(accountDAO.getServiceCode());
		
		membershipDAO.addAccount();
		
		//close spring context
		context.close();
		
	}

}
