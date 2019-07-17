package com.secondMaven.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

////process query that will give result of street address, city and country name
//and store results inside the list
public class Task2 {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:orcl";

	String dbUsername = "Syntax";

	String dbPassword = "syntax123";

	@Test
	public void collectAddresses() throws SQLException {

		Connection cn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

		Statement st = cn.createStatement();

		String sql = "Select street_address,city,country_name\n" + "from locations l join countries c\n"
				+ "on l.country_id=c.country_id";

		ResultSet rs = st.executeQuery(sql);
		
		
		
	List<Map<String, String>> rsList=new ArrayList<>();
	
	while(rs.next()) {
		Map<String,String> rsMap=new HashMap<>();
		
		rsMap.put("STREET_ADDRESS", rs.getString("STREET_ADDRESS"));
		rsMap.put("CITY", rs.getString("CITY"));
		rsMap.put("COUNTRY_NAME", rs.getString("COUNTRY_NAME"));
		rsList.add(rsMap);
		
		
	}

	
	System.out.println(rsList);

	rs.close();
	st.close(); 
	cn.close();
	
	
	
	
	
	}

}
