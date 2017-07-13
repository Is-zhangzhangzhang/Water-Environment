package com.scau.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.scau.dao.ClassMapper;
import com.scau.dao.DatabaseMapper;
import com.scau.pojo.Database;
import com.scau.service.IDatabaseService;
@Service("databaseService")
public class DatabaseServiceImpl  implements IDatabaseService{

	@Resource
    private DatabaseMapper databaseMapper;
	
	@Override
	public List<String> getAllDB() {
		return databaseMapper.getAllDB();
	}

	@Override
	public List<String> getTables(Database database) {
		return databaseMapper.getTables(database);
	}

	@Override
	public String getDBSize(String dbName) {
		return databaseMapper.getDBSize(dbName);
	}

	@Override
	public List<String> getTableColumes(String dbName, String tbName) {
		return databaseMapper.getTableColumes(dbName, tbName);
	}

	@Override
	public List<String> getColumnData(String dbName, String tbName,
			String columnName) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("dbName", dbName);
		map.put("tbName", tbName);
		map.put("columnName", columnName);
		return databaseMapper.getColumnData(map);	
	}

}
