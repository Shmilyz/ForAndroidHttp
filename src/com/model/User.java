package com.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private int id ;
	private String name ;
	private String pwd ;
	private Date birthday ;
	private int[] loc ;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int[] getLoc() {
		return loc;
	}
	public void setLoc(int[] loc) {
		this.loc = loc;
	}
	public User(int id, String name, String pwd, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.birthday = birthday;
	}
	
}
