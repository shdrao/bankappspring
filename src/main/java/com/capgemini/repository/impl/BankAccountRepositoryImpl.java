package com.capgemini.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.BankAccount;
import com.capgemini.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public double getBalance(long accountId) throws Exception {
		return jdbcTemplate.queryForObject("SELECT balance from account where accountId=?", new Object[] { accountId },
				Double.class);
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
		int count = jdbcTemplate.update("UPDATE account SET balance=? where accountId=?",
				new Object[] { newBalance,accountId });
		return (count != 0);
	}

	@Override
	public boolean addBankAccount(BankAccount account) {
		int count = jdbcTemplate.update("INSERT into account values(?,?,?,?)", new Object[] { account.getAccountId(),
				account.getAccountHolderName(), account.getAccountType(), account.getAccountBalance() });
		return (count != 0);
	}

	@Override
	public BankAccount findBankAccountById(long accountId) {
		return jdbcTemplate.queryForObject("SELECt * from account where accountid=?", new Object[] {accountId},new BankAccountRowMapper());

		
	}

	@Override
	public List<BankAccount> findAllBankAccounts() {
		return jdbcTemplate.query("SELECT * FROM account",new Object[] {}, new BankAccountRowMapper());
	}

	@Override
	public BankAccount updateBankAccount(BankAccount account) {
		int count = jdbcTemplate.update("UPDATE account SET  customerName=? , accountType=?  where accountId=?",
				new Object[] { account.getAccountHolderName(), account.getAccountType(), account.getAccountId() });
		if (count != 0) {
			return account;
		} else
			return findBankAccountById(account.getAccountId());
	}

	@Override
	public boolean deleteBankAccount(long accountId) {
		int count = jdbcTemplate.update("DELETE from account where accountId=?", new Object[] { accountId });
		return (count != 0);
	}
	
	private class BankAccountRowMapper implements RowMapper<BankAccount>{

		@Override
		public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
			BankAccount account= new BankAccount();
			account.setAccountBalance(rs.getDouble(4));
			account.setAccountType(rs.getString(3));
			account.setAccountHolderName(rs.getString(2));
			account.setAccountId(rs.getInt(1));
			return account;
			
		}
		
		
	}

}
