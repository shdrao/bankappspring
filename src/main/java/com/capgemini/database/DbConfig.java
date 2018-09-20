package com.capgemini.database;

public class DbConfig {

	private String dbUser;

	private String dbUrl;
	private String dbPassword;




	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	@Override
	public String toString() {
		return "DbConfig [dbHost=" + dbUser + ", dbUrl=" + dbUrl + ", dbPassword=" + dbPassword + "]";
	}

}
