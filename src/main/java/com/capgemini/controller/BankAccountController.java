package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.capgemini.exceptions.LowBalanceException;
import com.capgemini.service.BankAccountService;

@Controller
public class BankAccountController {
	@Autowired
	private BankAccountService bankAccountService;
//@Autowired
//	private BankAccountController(BankAccountService bankAccountService) {
//		super();
//		this.bankAccountService = bankAccountService;
//	}
	



//	public void setBankAccountService(BankAccountService bankAccountService) {
//		this.bankAccountService = bankAccountService;
//	}


	public double getBalance(long accountId) throws Exception {
		return bankAccountService.getBalance(accountId);
	}

	public double withdraw(long accountId, double amount) throws Exception {
		return bankAccountService.withdraw(accountId, amount);
	}

	public double deposit(long accountId, double amount) throws Exception {
		return bankAccountService.deposit(accountId, amount);
	}

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws Exception {
		return bankAccountService.fundTransfer(fromAccount, toAccount, amount);
	}
}
