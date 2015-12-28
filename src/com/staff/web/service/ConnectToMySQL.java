package com.staff.web.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import com.staff.service.web.model.StaffInfo;

public class ConnectToMySQL {

	private static Connection conn = null;
	static Statement stmt;
	private static Map<String, StaffInfo> sampleStaff;
	private static String user = "dunnj";
	private static String password = "grustpOl8";
	private static String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/" + user;

	public static Map<String,StaffInfo> getStaffMembers() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
		// get a connection with the user/pass
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DEBUG: Connection to database successful.");
			stmt = conn.createStatement();
		} catch (SQLException se) {
			System.out.println("DEBUG: Failed to connect: " + se);
		}
		String selectSQL = null;
		selectSQL = "select * from staff_info;";
		sampleStaff = new LinkedHashMap<String, StaffInfo>();
		try {
			ResultSet results = stmt.executeQuery(selectSQL);
			while (results.next()) {
				String id = results.getString(1);
				sampleStaff.put(id, new StaffInfo(Integer.parseInt(id), results.getString(2), results.getString(3),
						results.getString(4), results.getString(5), results.getString(6)));

			}
		} catch (SQLException ex) {
			System.out.println("Error in SQL " + ex.getMessage());
		}

		return sampleStaff;
	}		
		
}
