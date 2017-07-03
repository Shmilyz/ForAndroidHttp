package com.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Insert extends ActionSupport{
	private String uname , upass ;
	private Map<String , Integer> map = new HashMap<String, Integer>() ;
	int results;
	public String execute() throws Exception {
		
			DBUtils db = new DBUtils();
			String name=uname;
			String pass=upass;
			int result = db.insert(uname);
			
//			"select id from login where username='"+name+"' and password='"+upass+"'"
			db.close();
			
			
			map.put("result", result) ;

			System.out.println(result);


		
			return SUCCESS ;

	       /* System.out.println(account.get("sean"));*/
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
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}}