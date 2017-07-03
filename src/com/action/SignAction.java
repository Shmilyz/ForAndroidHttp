package com.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.action.JDBCOperation.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class SignAction extends ActionSupport{
	private String uname , upass ;
	private Map<String , String> map = new HashMap<String, String>() ;
	
	public String execute() throws Exception {
		 /*Map<String,String> account = new HashMap<String, String>();
	       try {
	    	    File file = new File("E:\\a.txt");
	    	    BufferedReader reader = null;
	           reader = new BufferedReader(new FileReader(file));
	           String tempString = null;
	           int line = 1;
	           while ((tempString = reader.readLine()) != null) {
	               if (!tempString.startsWith("#")) {
	                   String[] strArray = tempString.split(":");
	                   account.put(strArray[0], strArray[1]);

	               }	               
	               line++;
	           }
	           
	           reader.close();

	            
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        Iterator it = account.keySet().iterator();
			while(it.hasNext()){
   				System.out.println(account);
				String key = (String) it.next();
				String value=account.get(key);
				System.out.println(uname);
				System.out.println(upass);
				map.clear();
				if(key.equalsIgnoreCase(uname)&&value.equalsIgnoreCase(upass))
				{
					System.out.println("正确");
					map.put("result", "true") ;
					break;
				}
				else{
					System.out.println("错误");
					map.put("result", "fa") ;
				}
				

			}*/
	   /* JDBCOperation.insert(new Login(uname,upass));
		System.out.println(uname);
		System.out.println(upass);*/
		if(uname!=null && upass!=null){
			
			DBUtils db = new DBUtils();
			String name=uname;
			String pass=upass;
			List<Map> list = db.query("select username from login where username='"+name+"'"+" or phone='"+name+"'"+" and password='"+upass+"'");
			
			db.close();

if(list.size() ==0){
	   map.put("result", "0") ;
   	map.put("username"," ");

	    list.clear();
}else{
	Map<String , String> mapp=list.get(0);
 String username=mapp.get("username");
	map.put("result", "1") ;
	map.put("username",username);
	System.out.println(list);
    list.clear();
}

		}else{
	        map.put("result", "0") ;
	    	map.put("username"," ");

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
