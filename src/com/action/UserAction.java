package com.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.mysql.jdbc.Driver;
import com.action.JDBCOperation.Login;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{
	private String uname , upass ;
	private Map<String , String> map = new HashMap<String, String>() ;
	public String execute() throws Exception {
		/*try {
			// TODO code application logic here 
			String a=uname;
			String b=upass;
			Map<String , String> map = new HashMap<String, String>();
			map.put(a,b);
			String line = System.getProperty("line.separator");
			StringBuffer str = new StringBuffer();
			FileWriter fw = new FileWriter("E:\\a.txt", true);
			Set set = (Set) map.entrySet();
			Iterator iter = ((java.util.Set) set).iterator();
			while(iter.hasNext()){
			Map.Entry entry = (Map.Entry)iter.next();
			str.append(entry.getKey()+" : "+entry.getValue()).append(line);
			}
			fw.write(str.toString());
			fw.close();
			} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
			} catch (IOException ex){
			System.out.println(ex.getMessage());
		}*/	
	    if(uname!="" && upass!=""){
	    	JDBCOperation.insert(new Login(uname, upass));
	        map.put("result", "1") ;
	    }else{
	    	 map.put("result", "0") ;
	    }
			
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
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}}
