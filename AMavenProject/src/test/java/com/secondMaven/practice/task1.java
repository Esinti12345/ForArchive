package com.secondMaven.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class task1 {
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";

	// display in console department id&department name in 1 row
	@Test
	public void hrDepartments() throws SQLException {
		Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("Select department_id,department_name from Departments");

		while (resultSet.next()) {
			int dep_id = resultSet.getInt("DEPARTMENT_ID");
			String dep_name = resultSet.getString("DEPARTMENT_NAME");
			System.out.println(dep_id + " " + dep_name);
			// Alternative way 1 shows first row 2 shows second row
			// System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
		}

		resultSet.close();
		statement.close();
		connection.close();

	}
}
