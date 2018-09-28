package com.capgemini.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.config.AppConfig;
import com.capgemini.controller.BankAccountController;
import com.capgemini.entity.BankAccount;
import com.capgemini.exceptions.LowBalanceException;

public class Application {
	public static void main(String[] args) throws Exception {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BankAccountController bankAccountController = context.getBean("bankAccountController",
				BankAccountController.class);
		System.out.println(bankAccountController.getBalance(1001));
//		System.out.println(bankAccountController.deposit(1000, 100));
//		System.out.println(bankAccountController.fundTransfer(1001, 1002, 100));
//		System.out.println(bankAccountController.withdraw(1001, 20));
//		System.out.println(bankAccountController.addBankAccount(new BankAccount(1005, "Rama", "Savings", 10000)));
//		System.out.println(bankAccountController.deleteBankAccount(1005));	
//		System.out.println(bankAccountController.findAllBankAccounts());
//		System.out.println(bankAccountController.findBankAccountById(1001));
//		System.out.println(bankAccountController.updateBankAccount(new BankAccount(1005,"Raama","Current",11000)));
	}

}
