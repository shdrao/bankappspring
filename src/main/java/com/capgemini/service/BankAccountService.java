package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.BankAccount;
import com.capgemini.exceptions.LowBalanceException;

public interface BankAccountService {
	public double getBalance(long accountId) throws Exception;

	public double withdraw(long accountId, double amount) throws LowBalanceException, Exception;

	public double deposit(long accountId, double amount) throws Exception;

	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws LowBalanceException, Exception;

	public boolean addBankAccount(BankAccount account);

	public BankAccount findBankAccountById(long accountId);

	public List<BankAccount> findAllBankAccounts();

	public BankAccount updateBankAccount(BankAccount account);

	public boolean deleteBankAccount(long accountId);
}
