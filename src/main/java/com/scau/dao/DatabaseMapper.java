package com.scau.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.scau.pojo.Database;



public interface DatabaseMapper {

	@Select({
		"show databases;"
	})
	List<String> getAllDB();

	
	List<String> getTables(Database database);
     
	@Select({
		"select concat(round(sum(data_length/1024/1024),2),'MB') as data from information_schema.tables where table_schema=#{dbName};"
	})
	String getDBSize(String dbName);
	
	@Select({
		"select COLUMN_NAME from information_schema.COLUMNS where table_schema=#{0} and TABLE_NAME=#{1};"
	})
	List<String> getTableColumes(String dbName, String tbName);
	

	List<String> getColumnData(Map<String,Object> map);
}
