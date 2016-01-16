/**
 * 
 */
package com.staff.service.web.dao;

import java.util.Map;
import com.staff.service.web.model.StaffInfo;

/**
 * @author joshuadunn
 *
 */
public interface StaffInterface {
	
	public abstract Map<String,StaffInfo> getStaffMembers();
	public abstract void addStaffMember(StaffInfo staff);

}
