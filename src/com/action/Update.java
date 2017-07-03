package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Update extends ActionSupport{
	private String uname , upass=" " ;
	private Map<String , String> map = new HashMap<String, String>() ;

	public String execute() throws Exception {
		
			DBUtils db = new DBUtils();
			String name=uname;
			int result = db.update(uname);
			
			db.close();
			System.out.println(result);
			if(result==1){
					
				if(!upass.equals(" ")){
					DBUtils dbs = new DBUtils();
					
					int results=dbs.update(upass);
					dbs.close();

					String string_results=String.valueOf(results);

					map.put("result", string_results) ;
				}
				
				
				String string_result=String.valueOf(result);

				map.put("result", string_result) ;

			}


		
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
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}}
