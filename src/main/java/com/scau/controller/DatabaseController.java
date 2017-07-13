package com.scau.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.scau.pojo.Database;
import com.scau.service.IAlgorithmService;
import com.scau.service.IDatabaseService;
import com.scau.util.SSHHold;

@Controller
@RequestMapping("/database")
public class DatabaseController {
	
	
	@Resource
    private IDatabaseService databaseService;
	
	/**
     * 列出数据库列表
     * @return dbNameList
     * @throws IOException
     */
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list( HttpServletResponse response, HttpServletRequest request, Model model){
		List<String> databaseList = databaseService.getAllDB();
		List<Database> databases = new ArrayList<Database>();
		for(String database:databaseList){
			String dbSize = databaseService.getDBSize(database);
			databases.add(new Database(database, dbSize));
		}
		model.addAttribute("dbList", databases);
		return "database/list";
	}
	
	@RequestMapping(value = "/listdbdetail",method = RequestMethod.GET)
    public String listTable( String dbname, HttpServletResponse response, HttpServletRequest request, Model model){
		System.out.println(dbname);
		
		List<String> tables = databaseService.getTables(new Database(dbname));
		
		Map<String , List<String>> map = new HashMap<String , List<String>>();
	//Map<String, Map<String, List<String>>> data = new HashMap<String, Map<String,List<String>>>();
		for (String table :tables){
			List<String> columns = databaseService.getTableColumes(dbname, table);
			map.put(table, columns);
		}
		model.addAttribute("tableMap", map);
		model.addAttribute("dbname", dbname);
		return "database/dbdetail";
	}
	
	@RequestMapping(value = "/getTableData")
    public void listTableData( String dbname, String tbname, HttpServletResponse response, HttpServletRequest request, Model model){
		System.out.println(dbname + " " + tbname);
		List<String> columns = databaseService.getTableColumes(dbname, tbname);
		List<List<String>> data = new ArrayList<List<String>>();
		
		for(String column : columns){
			List<String> coldatas = databaseService.getColumnData(dbname, tbname, column);
			//System.out.println(coldatas);
			data.add(coldatas);
			//json.put(column, coldatas);
			
		}
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		for (int i = 0; i < data.get(0).size(); ++i) {
			JSONObject json = new JSONObject();
			for (int j = 0; j < columns.size(); ++j) {
				json.put(columns.get(j), data.get(j).get(i));
			}
			jsonList.add(json);
		}
		
		System.out.println(JSONObject.toJSON(jsonList).toString());
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONObject.toJSON(jsonList).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@RequestMapping(value = "/hdfs",method = RequestMethod.GET)
    public String hdfs( HttpServletResponse response, HttpServletRequest request, Model model){
		return "database/hdfs";
	}
	
	/**
	 * 传递数据库执行语句，返回结果
	 */
	@RequestMapping(value = "/execute",method = RequestMethod.GET)
	public void execute(String command, HttpServletRequest request, HttpServletResponse response){
		try {
			SSHHold sshHold = (SSHHold)request.getSession().getAttribute("ssh_conn");
			System.out.println("sshHold"+sshHold);
			if (sshHold == null) {
				sshHold = new SSHHold();
				request.getSession().setAttribute("ssh_conn", sshHold);
			}
			sshHold.ssh(command);
			String result = null;
			try {
				result = sshHold.getLogs();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			response.setContentType("text/html;charset=utf-8");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(result);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
