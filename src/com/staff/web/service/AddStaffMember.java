/**
 * 
 */
package com.staff.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.staff.service.web.model.StaffInfo;

/**
 * @author joshuadunn
 *
 */

public class AddStaffMember {

	public Connection connection;
	private static String user = "dunnj";
	private static String password = "grustpOl8";
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/" + user;

	public AddStaffMember() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connected");
			connection = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("Disconnected");
		}
	}

	public void addStaffMember(StaffInfo staff) throws SQLException {
		String query = "insert into staff_info (staff_id, forename, surname, address, phone_number, email) values (?,?,?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, staff.getStaffID());
			statement.setString(2, staff.getForename());
			statement.setString(3, staff.getSurname());
			statement.setString(4, staff.getLocation());
			statement.setString(5, staff.getPhone());
			statement.setString(6, staff.getEmail());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
