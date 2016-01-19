///**
// * 
// */
//package com.staff.web.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import com.google.appengine.api.datastore.DatastoreService;
//import com.google.appengine.api.datastore.DatastoreServiceFactory;
//import com.google.appengine.api.datastore.Entity;
//import com.staff.service.web.model.StaffInfo;
//
///**
// * @author joshuadunn
// *
// */
//
//public class AddStaffMember {
//
//	public Connection connection;
//	private static String user = "dunnj";
//	private static String password = "grustpOl8";
//	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/" + user;
//
//	public AddStaffMember() {
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			System.out.println("Connected");
//			connection = DriverManager.getConnection(url, user, password);
//		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//			System.out.println("Disconnected");
//		}
//	}
//
////	public void addStaffMember(StaffInfo staff) throws SQLException {		
////		DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();
////		Entity staffMember = new Entity("StaffDetails");
////		staffMember.setProperty("Forename", staff.getForename());
////		staffMember.setProperty("Surname",  staff.getSurname());
////		staffMember.setProperty("Email", staff.getEmail());
////		staffMember.setProperty("Phone_Num", staff.getPhone());
////		staffMember.setProperty("Address", staff.getLocation());
////
////		//Add the data to the GAE Datastore
////		dataStoreService.put(staffMember);
////	}
//}
