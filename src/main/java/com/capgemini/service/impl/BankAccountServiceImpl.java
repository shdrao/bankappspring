package com.capgemini.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.BankAccount;
import com.capgemini.exceptions.LowBalanceException;
import com.capgemini.repository.BankAccountRepository;
import com.capgemini.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
@Autowired
	private BankAccountRepository bankAccountRepository;

//	public void setBankAccountRepository(BankAccountRepository bankAccountRepository) {
//		this.bankAccountRepository = bankAccountRepository;
//	}
//	@Autowired
//	private BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
//		super();
//		this.bankAccountRepository = bankAccountRepository;
//	}

	@Override
	public double getBalance(long accountId) throws Exception {
		return bankAccountRepository.getBalance(accountId);
	}

	@Override
	public double withdraw(long accountId, double amount) throws Exception {
		double balance = bankAccountRepository.getBalance(accountId);
		if (balance != -1) {
			if (balance - amount >= 0) {
				bankAccountRepository.updateBalance(accountId, balance - amount);
				return bankAccountRepository.getBalance(accountId);
			} else
				throw new LowBalanceException("Not enough sufficient Balance");
		}
		return balance;
	}

	@Override
	public double deposit(long accountId, double amount) throws Exception {
		double balance = bankAccountRepository.getBalance(accountId);
		
		if (balance != -1) {
			
			bankAccountRepository.updateBalance(accountId, balance + amount);
			System.out.println("ser"+bankAccountRepository.getBalance(accountId));
			return bankAccountRepository.getBalance(accountId);
		}
		return balance;
	}

	@Override
	public boolean fundTransfer(long fromAccount, long toAccount, double amount) throws Exception {
		double balance = withdraw(fromAccount, amount);
		if (balance != -1) {
			if (deposit(toAccount, amount) == -1) {
				return false;
			}
			return true;
		}
		return false;

	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		
		return bankAccountRepository.addBankAccount(account);
	}

	@Override
	public BankAccount findBankAccountById(long accountId) {
		
		return bankAccountRepository.findBankAccountById(accountId);
	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		
		return bankAccountRepository.findAllBankAccounts();
	}

	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		
		return bankAccountRepository.updateBankAccount(account);
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		
		return bankAccountRepository.deleteBankAccount(accountId);
	}
}