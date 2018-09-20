package com.capgemini.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.database.DbUtil;
import com.capgemini.repository.BankAccountRepository;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {
	// private HashSet<BankAccount> accounts;

//	public BankAccountRepositoryImpl() {
//		super();
//		accounts = new HashSet<>();
//		accounts.add(new BankAccount(1000, "Sharath D Rao", "savings", 10000));
//		accounts.add(new BankAccount(1001, "Sudarshan Shanbhag", "savings", 10000));
//		accounts.add(new BankAccount(1002, "Sandeep Das", "savings", 10000));
//		accounts.add(new BankAccount(1003, "Shashank Kumar", "savings", 10000));
//		accounts.add(new BankAccount(1004, "Poornesh K", "savings", 10000));
//
//	}
	@Autowired
	private DbUtil dbUtil;

	@Override
	public double getBalance(long accountId) throws Exception {
//		for (BankAccount bankAccount : accounts) {
//			if (bankAccount.getAccountId() == accountId) {
//				return bankAccount.getAccountBalance();
//			}
//		}
//		return -1;

		String query = "SELECT * FROM account where accountId=?";

		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setLong(1, accountId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {

				return result.getDouble(4);

			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		throw new Exception("No Account found");
	}

	@Override
	public boolean updateBalance(long accountId, double newBalance) {
//		for (BankAccount bankAccount : accounts) {
//			if (bankAccount.getAccountId() == accountId) {
//				bankAccount.setAccountBalance(newBalance);
//				return true;
//			}
//		}
//		return false;
		// }

		String query = "update account set balance = ? where accountId = ?";
		try (Connection connection = dbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setDouble(1, newBalance);
			statement.setLong(2, accountId);
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
}
