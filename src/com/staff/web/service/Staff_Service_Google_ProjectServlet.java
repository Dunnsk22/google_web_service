package com.staff.web.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;


@SuppressWarnings("serial")
public class Staff_Service_Google_ProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
				
		DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();
		
		Query query = new Query("Staff").addSort("Forename", Query.SortDirection.ASCENDING);
		PreparedQuery prep = dataStoreService.prepare(query);
		for (Entity entity : prep.asIterable()) {
			String idKey = entity.getKey().toString();
			String id = idKey.substring(idKey.indexOf("(") + 1, idKey.indexOf(")"));
			String forename = entity.getProperty("Forename").toString();
			String surname = entity.getProperty("Surname").toString();
			String age = entity.getProperty("Age").toString();
			String address = entity.getProperty("Address").toString();
			
			System.out.println("Entity is " + entity);
			System.out.println("The id is " + id);
		}
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
