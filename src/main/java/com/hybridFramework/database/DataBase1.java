package com.hybridFramework.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Hari krishna
 * https://www.youtube.com/user/MrBhanupratap29/playlists
 */
public class DataBase1 {
	Connection conn;
	Statement stmt;
	public  Statement getStatement() throws ClassNotFoundException, SQLException
	{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String conUrl = "jdbc:mysql://localhost:3307//products";
			String userName = "root";
			String password = "password";
			
			Class.forName(driver);
			conn = DriverManager.getConnection(conUrl,userName,password);
			stmt = conn.createStatement();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return stmt;
	}

	public void insertData(String query) throws ClassNotFoundException, SQLException
	{
		Statement stmtt = getStatement();
		stmtt.executeUpdate(query);
	}
	public ResultSet getData(String query) throws ClassNotFoundException, SQLException
	{
		ResultSet data = getStatement().executeQuery(query);
		return data;
	}
	public void updateData(String query) throws ClassNotFoundException, SQLException
	{
		getStatement().executeUpdate(query);
	}
}
