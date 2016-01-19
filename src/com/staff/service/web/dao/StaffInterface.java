package com.staff.service.web.dao;

import java.util.List;
import java.util.Map;

import com.staff.service.web.model.StaffInfo;

/**
 * ENTERPRISE PROGRAMMING
 * 
 * @author joshuadunn
 * Interface providing methods for the StaffDAO Class
 * 
 *
 */

public interface StaffInterface {

	/**
	 * 
	 * getStaffMembers() - Returns a List containing StaffInfo's from the GAE
	 * addStaffMember(StaffInfo staff) - Adds a StaffInfo object to the GAE Datastore
	 * getStaffMemberByName(String in, String in) - Returns a List of Staff Members based on first and second names
	 *                        
	 */
	
	public abstract Map<String, StaffInfo> getStaffMembers();

	public abstract void addStaffMember(StaffInfo staff);

	public abstract List<StaffInfo> getStaffMemberByName(String firstName, String lastName);

}
