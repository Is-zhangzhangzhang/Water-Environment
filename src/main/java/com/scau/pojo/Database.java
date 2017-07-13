package com.scau.pojo;

import java.util.Date;

public class Database {
	private String databaseName;
	private Date createDate;
	private String size;
	public Database() {

	}
	public Database(String databaseName, String size) {
		this.databaseName = databaseName;
		this.size = size;
	}
	public Database(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
