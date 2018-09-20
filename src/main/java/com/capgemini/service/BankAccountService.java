package com.capgemini.service;

import com.capgemini.exceptions.LowBalanceException;

public interface BankAccountService {
	public double getBalance(long accountId) throws Exception;
	public double withdraw(long accountId, double amount) throws LowBalanceException, Exception;
	public double deposit(long accountId, double amount) throws Exception;
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException, Exception;

}
