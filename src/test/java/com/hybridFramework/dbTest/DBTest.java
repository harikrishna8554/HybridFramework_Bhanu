package com.hybridFramework.dbTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hybridFramework.database.DataBase;



public class DBTest{
	WebDriver driver;
	
	//@Test
	public void selectDBdata() throws ClassNotFoundException, SQLException{
		
		String query = "select * from registration;";
		
		DataBase dataBase = new DataBase();
		ResultSet data = dataBase.getData(query);
		System.out.println(data);
		while(data.next()){
			System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
		}
		
	}
	
	//@Test
	public void insertDBdata() throws ClassNotFoundException, SQLException{
		String query = "insert into registration values('2','bhnau12','5000')";
		DataBase dataBase = new DataBase();
		dataBase.insertData(query);	
	}
	
	@Test
	public void updateDBdata() throws ClassNotFoundException, SQLException{
		String query = "update registration set ename='56777' where sal='5000'";
		DataBase dataBase = new DataBase();
		dataBase.updateData(query);
		
	}

}
