package com.action;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.mysql.jdbc.Driver;
import com.action.JDBCOperation.Login;
import com.model.NumberResult;
import com.model.Numbers;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
//测试


public class Contacts extends ActionSupport{
	private String uname , upass ;
	private Map<String , List> map = new HashMap<String, List>() ;
	List<NumberResult> result=new ArrayList<>();
	public String execute() throws Exception {
		   JSONArray array = JSONArray.fromObject(uname);
	        List<Numbers> list = JSONArray.toList(array, Numbers.class);
			System.out.println(list.get(0).getNumber());

	        for(int i=0;i<list.size();i++){
	        	DBUtils db = new DBUtils();
				String name="select id,username from login where phone='"+list.get(i).getNumber()+"'";
				List<Map> resultlist = db.query(name);
				db.close();
				if(resultlist.size() >0){
					Map<String , String> mapp=resultlist.get(0);
					Map<String , Integer> mapps=resultlist.get(0);

					 String username=mapp.get("username");
					 int id=mapps.get("id");
						System.out.println(String.valueOf(resultlist.get(0)));
					NumberResult numberresult=new NumberResult();
					
					numberresult.setName(list.get(i).getName());
					numberresult.setUsername(username);
					numberresult.setId(id);
					numberresult.setPhone(list.get(i).getNumber());
					result.add(numberresult);
					
				}
				
	        }
		
		
  	 map.put("result",result) ;


			
			        return SUCCESS ;					
	};

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public Map<String, List> getMap() {
		return map;
	}
	public void setMap(Map<String, List> map) {
		this.map = map;
	}}
