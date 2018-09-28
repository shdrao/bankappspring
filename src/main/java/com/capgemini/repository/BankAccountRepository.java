package com.capgemini.repository;

import java.util.List;


import com.capgemini.entity.BankAccount;

public interface BankAccountRepository {
	public double getBalance(long accountId) throws Exception;

	public boolean updateBalance(long accountId, double newBalance);

	public boolean addBankAccount(BankAccount account);

	public BankAccount findBankAccountById(long accountId);

	public List<BankAccount> findAllBankAccounts();

	public BankAccount updateBankAccount(BankAccount account);

	public boolean deleteBankAccount(long accountId);
}
