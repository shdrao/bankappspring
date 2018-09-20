package com.capgemini.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.config.AppConfig;
import com.capgemini.controller.BankAccountController;
import com.capgemini.exceptions.LowBalanceException;

public class Application {
	public static void main(String[] args) throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
	System.out.println(bankAccountController.getBalance(1001));
//System.out.println(bankAccountController.deposit(1001, 100));
	//	System.out.println(bankAccountController.fundTransfer(1001, 1002, 100));
		//System.out.println(bankAccountController.withdraw(1001, 20));

	}

}
