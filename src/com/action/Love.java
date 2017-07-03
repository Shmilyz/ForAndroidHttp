package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Love extends ActionSupport{
	private String uname , upass ;
	private Map<String , String> map = new HashMap<String, String>() ;
	int result;
	public String execute() throws Exception {
		String name=uname;
		String pass=upass;
		
		
			DBUtils db = new DBUtils();
			System.out.println("SSS"+uname);

			int results = db.update(uname);
			System.out.println("SS"+String.valueOf(results));
			db.close();
			
//String string_result=String.valueOf(results);

				if(results==1){
					DBUtils dbs = new DBUtils();
					System.out.println("SSS"+upass);

					result = dbs.update(upass);
					System.out.println("SS"+String.valueOf(result));
					dbs.close();
				}



String string_result=String.valueOf(result);


	map.put("result", string_result) ;

		
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

