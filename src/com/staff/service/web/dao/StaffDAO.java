package com.staff.service.web.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.staff.service.web.model.StaffInfo;

/**
 * @author joshuadunn
 * @param staffMapData
 *            - Linked Hash Map storing the records pulled from the GAE
 *            datastore
 *
 */
public class StaffDAO implements StaffInterface {
	private static Map<String, StaffInfo> staffMapData;
	private static Map<String, StaffInfo> staffListData = new LinkedHashMap<String, StaffInfo>();


	public Map<String, StaffInfo> getStaffMembers() {
		DatastoreService dataStoreService = DatastoreServiceFactory
				.getDatastoreService();
		staffMapData = new LinkedHashMap<String, StaffInfo>();
		Query query = new Query("StaffDetails");
		PreparedQuery prep = dataStoreService.prepare(query);
		for (Entity entity : prep.asIterable()) {
			String idKey = entity.getKey().toString();
			String id = idKey.substring(idKey.indexOf("(") + 1,
					idKey.indexOf(")"));
			String forename = entity.getProperty("Forename").toString();
			String surname = entity.getProperty("Surname").toString();
			String email = entity.getProperty("Email").toString();
			String address = entity.getProperty("Address").toString();
			String phone_num = entity.getProperty("Phone_Num").toString();
			staffMapData.put(id, new StaffInfo(id, forename, surname, address,
					email, phone_num));
		}
		return staffMapData;
	}

	public void addStaffMember(StaffInfo staff) {
		DatastoreService dataStoreService = DatastoreServiceFactory
				.getDatastoreService();
		Entity staffMember = new Entity("StaffDetails");
		staffMember.setProperty("Forename", staff.getForename());
		staffMember.setProperty("Surname", staff.getSurname());
		staffMember.setProperty("Email", staff.getEmail());
		staffMember.setProperty("Phone_Num", staff.getPhone());
		staffMember.setProperty("Address", staff.getLocation());

		// Add the data to the GAE Datastore
		dataStoreService.put(staffMember);
	}
}
