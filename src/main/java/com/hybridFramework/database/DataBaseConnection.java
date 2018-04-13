package com.hybridFramework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseConnection {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3307/products";
		String user = "root";
		String password = "password";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Statement stmt = conn.createStatement();
		
		ResultSet result = stmt.executeQuery("select * from registration;");
		ArrayList<Object> l=new ArrayList<Object>();
		while(result.next())
		{
			l.add(result.getInt(1)+":::"+result.getString(2)+":::"+result.getInt(3));
		}
		System.out.println(l);
		
	}

}
