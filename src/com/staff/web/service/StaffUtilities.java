/**
 * 
 */
package com.staff.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.model.StaffInfo;

public class StaffUtilities {
	private static Map<String, StaffInfo> staffListData = new LinkedHashMap<String, StaffInfo>();

	public static Map<String, StaffInfo> getSampleStaff() {
		staffListData = StaffDAO.getStaffMembers();
		return staffListData;
	}

	public static List<StaffInfo> findAllStaff() {
		Map<String, StaffInfo> staffInfoMap = getSampleStaff();
		ArrayList<StaffInfo> staffList = new ArrayList<StaffInfo>();
		for (StaffInfo info : staffInfoMap.values()) {
			staffList.add(info);
		}
		return staffList;
	}

	public static List<StaffInfo> findAllStaffByName(String name) {
		
		Map<String, StaffInfo> staffInfoMap = getSampleStaff();
		ArrayList<StaffInfo> staffList = new ArrayList<StaffInfo>();
		for (StaffInfo c : staffInfoMap.values()) {
			staffList.add(c);
		}
		return staffList;
	}

//	public static StaffInfo getCustomer(String id) {
//		if (id == null) {
//			id = "unknown";
//		}
//		return staffListData.get(id.toLowerCase());
//	}

	public static List<StaffInfo> getNamedCustomer(String firstname, String lastname) {
		Map<String, StaffInfo> staffInfoMap = getSampleStaff();
		ArrayList<StaffInfo> staffList = new ArrayList<StaffInfo>();
		for (StaffInfo info : staffInfoMap.values()) {
			if (info.getForename().equalsIgnoreCase(firstname) && (info.getSurname().equalsIgnoreCase(lastname))) {
				staffList.add(info);
			}
		}
		return staffList;
	}

	public static StaffInfo getNamedCustomerByFirstOrSecondName(String firstName, String lastName) {
		Collection<StaffInfo> staff = getSampleCustomers().values();
		for (StaffInfo staffObject : staff) {
			if ((staffObject.getForename().equalsIgnoreCase(firstName))
					&& (staffObject.getSurname().equalsIgnoreCase(lastName))) {
				return staffObject;
			}
		}
		return (null);
	}

	public static Map<String, StaffInfo> getSampleCustomers() {
		return (staffListData);
	}

//	  public static StaffInfo getCustomerOrDefault(String id) {
//		    StaffInfo staffInfo = getCustomer(id);
//		    String unknown = "Unknown";
//		    if (staffInfo == null) {
//		      staffInfo = new StaffInfo(id, unknown, unknown, unknown, unknown, unknown);
//		    }
//		    return(staffInfo);
//		  }
}
