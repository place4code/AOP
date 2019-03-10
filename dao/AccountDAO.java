package com.place4code.aopdemo.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.place4code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;

	public void addAccount(Account account) {
		System.out.println("AccountDAO");
	}

	public String getServiceCode() {
		System.out.println("getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("setServiceCode()");
		this.serviceCode = serviceCode;
	}

	public String getName() {
		System.out.println("getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("setName()");
		this.name = name;
	}
	
	//add a new method: findAccounts
	public List<Account> findAccounts() {
		
		//create and return sample accounts
		return Arrays.asList(
				new Account("Account 1", "Level 1"),
				new Account("Account 2", "Level 2"),
				new Account("Account 3", "Level 3")
				);
	}
	
}
