package com.staff.service.web.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.staff.service.web.model.StaffInfo;

/**
 * @author joshuadunn
 * 
 *         ENTERPRISE PROGRAMMING
 *
 */

public class StaffDAO implements StaffInterface {
	private static Map<String, StaffInfo> staffMapData;
	private static Map<String, StaffInfo> staffListData = new LinkedHashMap<String, StaffInfo>();
	static StaffInterface staffInterface = new StaffDAO();
	DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();


	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.staff.service.web.dao.StaffInterface#getStaffMembers()
	 */
	public Map<String, StaffInfo> getStaffMembers() {
		DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();
		staffMapData = new LinkedHashMap<String, StaffInfo>();
		Query query = new Query("StaffDetails");
		PreparedQuery googleQuery = dataStoreService.prepare(query);
		
		if (googleQuery.countEntities(FetchOptions.Builder.withDefaults()) < 1) {
			addNewDatastoreEntry();
		}
		
		for (Entity datastoreEntity : googleQuery.asIterable()) {
			String idKey = datastoreEntity.getKey().toString();
			String id = idKey.substring(idKey.indexOf("(") + 1,idKey.indexOf(")"));
			String forename = datastoreEntity.getProperty("Forename").toString();
			String surname = datastoreEntity.getProperty("Surname").toString();
			String email = datastoreEntity.getProperty("Email").toString();
			String address = datastoreEntity.getProperty("Address").toString();
			String phone_num = datastoreEntity.getProperty("Phone_Num")
					.toString();
			staffMapData.put(id, new StaffInfo(id, forename, surname, address,
					email, phone_num));
		}
		return staffMapData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.staff.service.web.dao.StaffInterface#addStaffMember(com.staff.service
	 * .web.model.StaffInfo)
	 */
	public void addStaffMember(StaffInfo staff) {
		Entity staffMember = new Entity("StaffDetails");
		staffMember.setProperty("Forename", staff.getForename());
		staffMember.setProperty("Surname", staff.getSurname());
		staffMember.setProperty("Email", staff.getEmail());
		staffMember.setProperty("Phone_Num", staff.getPhone());
		staffMember.setProperty("Address", staff.getLocation());

		// Add the data to the GAE Datastore
		dataStoreService.put(staffMember);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.staff.service.web.dao.StaffInterface#getStaffMemberByName(java.lang
	 * .String, java.lang.String)
	 */
	public Map<String, StaffInfo> getStaffMemberByName(String firstname,
			String lastname) {
		Map<String, StaffInfo> staffInfoMap = getDatastoreEntries();
		Map<String, StaffInfo> staffList = new LinkedHashMap<String, StaffInfo>();
		for (StaffInfo info : staffInfoMap.values()) {
			if (info.getForename().equalsIgnoreCase(firstname)
					&& (info.getSurname().equalsIgnoreCase(lastname))) {
				staffList.put(
						info.getStaffID(),
						new StaffInfo(info.getStaffID(), info.getSurname(),
								info.getForename(), info.getLocation(), info
										.getPhone(), info.getEmail()));
			}
		}
		return staffList;
	}

	/*
	 * @return static Map with a String key and StaffInfo value
	 */
	public static Map<String, StaffInfo> getDatastoreEntries() {
		staffListData = staffInterface.getStaffMembers();
		return staffListData;
	}
	
	/** 
	 * 
	 * Adds Two New Entities to the GAE Datastore for testing locally
	 *
	 */
	public void addNewDatastoreEntry() {
		Entity staffMember = new Entity("StaffDetails");
		staffMember.setProperty("Forename", "Johnathon");
		staffMember.setProperty("Surname", "Robson");
		staffMember.setProperty("Email", "robby_john@me.com");
		staffMember.setProperty("Phone_Num", "01887 223112");
		staffMember.setProperty("Address", "22 Hataway Close, Biddulph, Stoke on Trent");

		Entity staffMemberTwo = new Entity("StaffDetails");
		staffMemberTwo.setProperty("Forename", "Kai");
		staffMemberTwo.setProperty("Surname", "Salt");
		staffMemberTwo.setProperty("Email", "salty_pig@me.com");
		staffMemberTwo.setProperty("Phone_Num", "01877 223112");
		staffMemberTwo.setProperty("Address", "2211 Runaway Drive, Congleton, Stoke on Trent");

		// Add the data to the GAE Datastore
		dataStoreService.put(staffMember);
		dataStoreService.put(staffMemberTwo);
		
	}
}
