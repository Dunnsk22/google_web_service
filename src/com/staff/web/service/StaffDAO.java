package com.staff.web.service;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.staff.service.web.model.StaffInfo;

public class StaffDAO {

	private static Map<String, StaffInfo> staffMapData;

	public static Map<String,StaffInfo> getStaffMembers() {
		DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();
		staffMapData = new LinkedHashMap<String, StaffInfo>();
		Query query = new Query("Staff").addSort("Forename", Query.SortDirection.ASCENDING);
		PreparedQuery prep = dataStoreService.prepare(query);
		for (Entity entity : prep.asIterable()) {
			String idKey = entity.getKey().toString();
			String id = idKey.substring(idKey.indexOf("(") + 1, idKey.indexOf(")"));
			String forename = entity.getProperty("Forename").toString();
			String surname = entity.getProperty("Surname").toString();
			String email = entity.getProperty("Email").toString(); 
			String address = entity.getProperty("Address").toString();
			String phone_num = entity.getProperty("Phone_Number").toString();
			staffMapData.put(id, new StaffInfo( id, forename, surname, address, phone_num, email ) );		
			}
		return staffMapData;
	}		
		
}
