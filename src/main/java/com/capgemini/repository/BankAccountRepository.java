package com.capgemini.repository;

public interface BankAccountRepository {
	public double getBalance(long accountId) throws Exception;
	public boolean updateBalance(long accountId, double newBalance);

}
