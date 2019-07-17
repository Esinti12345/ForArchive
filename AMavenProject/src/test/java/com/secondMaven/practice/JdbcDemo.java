package com.secondMaven.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {
	
	String dbUrl="jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";
	
	String dbUsername="Syntax";
	
	String dbPassword="syntax123";
	
	@Test
	public void jbConnection() throws SQLException {
		//creating a connection
		Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		
		//create a statement 
		Statement statement=connection.createStatement();
		
		//execute Query and store results database in ResultSet object
		ResultSet resultSet=statement.executeQuery("Select * from Countries");
		
		// get values from resultSet
		resultSet.next();
		String columData=resultSet.getString("Country_Name");
		System.out.println(columData);
		
		resultSet.next();
		columData=resultSet.getString("Country_Name");
		System.out.println(columData);
		
		while(resultSet.next()) {
			columData=resultSet.getString("Country_Name");
			System.out.println(columData);
			
		}
		//display in console department id&department name in 1 row
		
		//close all db connections
		resultSet.close();
		statement.close();
		connection.close();
	}
	

}
