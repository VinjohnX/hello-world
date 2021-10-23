package com.Sample_Prep.PreparationCodes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Sample_SQLConnection {
	
	
	@Test(testName = "DBConnection")
	public void mysqlconnectionDB() throws SQLException
	{
		String host = "localhost";
		String port = "3306";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qatestdb","root","Test@94");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from EmployeeInfo where name='vineeth'");
		while(rs.next())
		{
			System.out.println(rs.getString("id")+" "+rs.getString("pwd"));
		}
	}

}
