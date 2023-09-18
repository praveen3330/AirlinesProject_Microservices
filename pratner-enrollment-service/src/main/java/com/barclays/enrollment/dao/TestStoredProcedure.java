package com.barclays.enrollment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 
 * @author Praveen by 22-Jun-2023
 * Description :
 *
 */
public class TestStoredProcedure {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/elps", "root", "1234");

		String storeproc = "CALL elps.ENROLLMENT_SP001 (?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
		
		CallableStatement csmt = connection.prepareCall(storeproc);
	
		csmt.setString(1, "web***");
		csmt.setString(2, "online***");
		csmt.setString(3, "sreenu-test");
		csmt.setInt(4, 1213);
		csmt.setString(5, "tech-test");
		csmt.setString(6, "mr");
		csmt.setString(7, "male");
		csmt.setInt(8, 99877656);
		csmt.setString(9, "hyderabad");
		csmt.setString(10, "hitechcity");
		csmt.setString(11, "TS");
		csmt.setString(12, "HYD");
		csmt.setString(13, "INDIA");
		csmt.setString(14, "508001");
		csmt.setString(15, "em1876543");
		csmt.setString(16, "praveenganji930@gmail.com");
		csmt.setString(17, "");
		csmt.setString(18, "21-06-1998");
		
		csmt.registerOutParameter(19, Types.VARCHAR);
		csmt.registerOutParameter(20, Types.VARCHAR);
		
		csmt.execute();
		
		String respCode = csmt.getString(19);
		String respMsg = csmt.getString(20);
		
		System.out.println("respCode :" + respCode + " :"+"respMsg : "+respMsg);
	}

}
