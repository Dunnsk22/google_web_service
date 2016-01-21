/**
 * 
 */
package com.staff.service.web.builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.dao.StaffInterface;
import com.staff.service.web.model.StaffInfo;

/**
 * @author joshuadunn
 *
 */
@XmlRootElement
public class ResponseBuilder {

	StaffInterface staffInterface = new StaffDAO();
	Map<String, StaffInfo> staffInfoList = staffInterface.getStaffMembers();
	List<StaffInfo> staffInfo = new ArrayList<StaffInfo>();


	public ResponseBuilder() {

	}

	public String buildXMLResponse(Map<String, StaffInfo> staffInfoList) {

		for (StaffInfo info : staffInfoList.values()) {
			staffInfo.add(info);
		}

		String sortedDataText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		sortedDataText = "<membersOfStaff>\n";
		for (int i = 0; i < staffInfoList.size(); i++) {

			sortedDataText += "\t<staffMember>\n";
			sortedDataText += "\t\t<id>" + staffInfo.get(i).getStaffID()
					+ "</id>\n";
			sortedDataText += "\t\t<forename>" + staffInfo.get(i).getForename()
					+ "</forename>\n";
			sortedDataText += "\t\t<surname>" + staffInfo.get(i).getSurname()
					+ "</surname>\n";
			sortedDataText += "\t\t<address>" + staffInfo.get(i).getLocation()
					+ "</address>\n";
			sortedDataText += "\t\t<phoneNumber>" + staffInfo.get(i).getPhone()
					+ "</phoneNumber>\n";
			sortedDataText += "\t\t<email>" + staffInfo.get(i).getEmail()
					+ "</email>\n";
			sortedDataText += "\t</staffMember>";
			sortedDataText += "\n";

		}
		return sortedDataText += "</membersOfStaff>";
	}

	
	public String buildJsonResponse(Map<String, StaffInfo> staffInfoList) {
		
		for (StaffInfo info : staffInfoList.values()) {
			staffInfo.add(info);
		}
		
		String sortedDataText = "[ ";

		for (int i = 0; i < staffInfo.size(); i++) {

			sortedDataText += "\t{\n\t\t\"id\":" + "\""
					+ staffInfo.get(i).getStaffID() + "\",\n";
			sortedDataText += "\t\t\"forename\":" + "\""
					+ staffInfo.get(i).getForename() + "\",\n";
			sortedDataText += "\t\t\"surname\":" + "\""
					+ staffInfo.get(i).getSurname() + "\",\n";
			sortedDataText += "\t\t\"address\":" + "\""
					+ staffInfo.get(i).getLocation() + "\",\n";
			sortedDataText += "\t\t\"phone\":" + "\""
					+ staffInfo.get(i).getPhone() + "\",\n";
			sortedDataText += "\t\t\"email\":" + "\""
					+ staffInfo.get(i).getEmail() + "\"\n\t}\n";

			if (staffInfoList.size() - i > 1) {
				sortedDataText += ",";
			}
		}

		return sortedDataText += "]";
	}
	
	public String buildTextResponse(Map<String, StaffInfo> staffInfoList) {
		for (StaffInfo info : staffInfoList.values()) {
			staffInfo.add(info);
		}
		String sortedDataText = "";
		for (int i = 0; i < staffInfo.size(); i++) {

			sortedDataText += " " + staffInfo.get(i).getStaffID()
					+ "#||#";
			sortedDataText += " " + staffInfo.get(i).getForename()
					+ "#||#";
			sortedDataText += " " + staffInfo.get(i).getSurname()
					+ "#||#";
			sortedDataText += " " + staffInfo.get(i).getLocation()
					+ "#||#";
			sortedDataText += " " + staffInfo.get(i).getPhone() + "#||#";
			sortedDataText += " " + staffInfo.get(i).getEmail();

			if (staffInfo.size() - i > 1) {
				sortedDataText += " " + "\n\n\n";
			}
		}
		return sortedDataText;
	}

}
