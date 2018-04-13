package com.hybridFramework.dbTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.hybridFramework.database.DataBase1;

public class DBTest1 {
	@Test
	public void getData() throws ClassNotFoundException, SQLException
	{
		String query = "select * from products.registration";
		DataBase1 db=new DataBase1();
		ResultSet data = db.getData(query);
		while(data.next())
		{
			System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3));
		}
		
	}

}
