package com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class Select extends ActionSupport{
	private String uname , upass ;
	private Map<String , List> map = new HashMap<String, List>() ;
	
	public String execute() throws Exception {
		
		
			
			DBUtils db = new DBUtils();
			String name=uname;
			String pass=upass;
			List<Map> list = db.query(uname);
//			"select id from login where username='"+name+"' and password='"+upass+"'"
			db.close();
			System.out.println(list);

if(list.size() ==0){
		System.out.println(list);

	    list.clear();
}else{
	
	System.out.println(list);
	map.put("result", list) ;

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
	public Map<String, List> getMap() {
		return map;
	}
	public void setMap(Map<String, List> map) {
		this.map = map;
	}}
