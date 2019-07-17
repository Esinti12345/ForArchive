package com.secondMaven.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaDataDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";

	
	@Test
	public void getMetaData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		DatabaseMetaData dbMetaData = conn.getMetaData();

		String dbName = dbMetaData.getDatabaseProductName();
		System.out.println(dbName);

		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM EMPLOYEES WHERE JOB_ID='IT_PROG'");

		ResultSetMetaData rsMetaData=rs.getMetaData();
		int colNum=rsMetaData.getColumnCount();
		System.out.println(colNum);
		
		String colName=rsMetaData.getColumnName(2);
		System.out.println(colName);
		System.out.println("------Printing all columm and name------");
		for(int i=1; i<=colNum; i++) {
			colName=rsMetaData.getColumnName(i);
			System.out.println(colName);
		}
		
		
		
		rs.close();
		st.close();
		conn.close();
		
		
	}

}