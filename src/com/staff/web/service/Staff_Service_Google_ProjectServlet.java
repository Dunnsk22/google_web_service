package com.staff.web.service;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class Staff_Service_Google_ProjectServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		
		DatastoreService dataStoreService = DatastoreServiceFactory.getDatastoreService();
					
		Entity staff = new Entity("Staff", 421);
		staff.setProperty("staff_id", 421);
		staff.setProperty("Forename", "Joe");
		staff.setProperty("Surname", "Pemberton");
		staff.setProperty("Age", "22");
		staff.setProperty("Address", "2 Agnes Road, Levenshulme, Manchester, M19 G5R");

		dataStoreService.put(staff);
		
		
		
		
		
		
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
	}
}
