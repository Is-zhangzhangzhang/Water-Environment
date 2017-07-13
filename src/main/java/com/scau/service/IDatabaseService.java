package com.scau.service;

import java.util.List;

import com.scau.pojo.Database;

public interface IDatabaseService {

	List<String> getAllDB();
	
	String getDBSize(String dbName);
	
	List<String> getTables(Database database);
	
	List<String> getTableColumes(String dbName,String tbName);
	
	List<String> getColumnData(String dbName,String tbName,String columnName);
}
