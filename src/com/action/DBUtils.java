package com.action;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.mysql.jdbc.Statement;
public class DBUtils {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DBUtils() {

		try {
			Properties properties = new Properties();
			properties.load(getClass().getResourceAsStream("config.properties"));
			Class.forName(properties.getProperty("driverName"));

			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("db connection error.");
		}

	}

	public List query(String sql, Object... objects) {
		ArrayList list = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				pstmt.setObject(i + 1, objects[i]);
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int coutColumn = rsmd.getColumnCount();

			while (rs.next()) {
				Map map = new HashMap();
				for (int i = 0; i < coutColumn; i++) {
					map.put(rsmd.getColumnLabel(i + 1), rs.getObject(i + 1));
				}
				list.add(map);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public int insert(String  sql) {
	    int i = 0;
	    

	    try {
	    	
	    	  pstmt =conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
              pstmt.executeUpdate(); 
              
		       ResultSet rs = pstmt.getGeneratedKeys(); 
               if (rs.next()) { 
                       //知其仅有一列，故获取第一列 
                       long id = rs.getLong(1); 
                       i=(int)id;
                       System.out.println("-----静态SQL模式-----id = " + id); 
               } 
		        System.out.println("resutl: " + String.valueOf(i));
		        pstmt.close();
		        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	
	public int update(String  sql) {
	    int i = 0;
	    
	    String sqls =sql;

	    try {
	    	
	        pstmt =conn.prepareStatement(sql);
	        i = pstmt.executeUpdate();
	        System.out.println("resutl: " + String.valueOf(i));
	        pstmt.close();
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return i;
	}
	
	
	
	
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println("db close error.");
		}
		;
	}
}
