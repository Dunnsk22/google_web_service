/**
 * 
 */
package com.staff.web.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.staff.service.web.model.StaffInfo;

public class FindStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sortedDataText = null;
		List<StaffInfo> staffInfoList = StaffUtils.findAllStaff();
		String format = request.getParameter("format");

		if (format.equalsIgnoreCase("json") ) {

			sortedDataText = "{ \"membersOfStaff\":[ ";

			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "{\"id\":" + "\"" + staffInfoList.get(i).getStaffID() + "\",";
				sortedDataText += "\"forename\":" + "\"" + staffInfoList.get(i).getForename() + "\",";
				sortedDataText += "\"surname\":" + "\"" + staffInfoList.get(i).getSurname() + "\",";
				sortedDataText += "\"address\":" + "\"" + staffInfoList.get(i).getLocation() + "\",";
				sortedDataText += "\"phone\":" + "\"" + staffInfoList.get(i).getPhone() + "\",";
				sortedDataText += "\"email\":" + "\"" + staffInfoList.get(i).getEmail() + "\"}";

				if (staffInfoList.size() - i > 1) {
					sortedDataText += ",";
				}
			}

			sortedDataText += "]}";

			System.out.println("JSON DATA:  " + sortedDataText);

		} else if (format.equalsIgnoreCase("xml") ) {
			sortedDataText = "&lt;membersOfStaff&gt;";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "&lt;staffMember&gt;\n\n \t \t&lt;id&gt;" + staffInfoList.get(i).getStaffID() + "&lt;/id&gt;\n";
				sortedDataText += "&lt;forename&gt;" + staffInfoList.get(i).getForename() + "&lt;/forename&gt;";
				sortedDataText += "&lt;surname&gt;" + staffInfoList.get(i).getSurname() + "&lt;/surname&gt;";
				sortedDataText += "&lt;address&gt;" + staffInfoList.get(i).getLocation() + "&lt;/address&gt;";
				sortedDataText += "&lt;phoneNumber&gt;" + staffInfoList.get(i).getPhone() + "&lt;/phoneNumber&gt;";
				sortedDataText += "&lt;email&gt;" + staffInfoList.get(i).getEmail() + "&lt;/email>&lt;/staffMember&gt;";

			}
			sortedDataText += "&lt;/membersOfStaff&gt; \n \n";
			System.out.println("XML DATA:  " + sortedDataText);

		} else if (format.equalsIgnoreCase("string") ) {
			
			sortedDataText = "membersOfStaff[ ";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "id=" + staffInfoList.get(i).getStaffID() + "#";
				sortedDataText += "forename=" + staffInfoList.get(i).getForename() + "#";
				sortedDataText += "surname=" + staffInfoList.get(i).getSurname() + "#";
				sortedDataText += "address=" + staffInfoList.get(i).getLocation() + "#";
				sortedDataText += "phoneNumber=" + staffInfoList.get(i).getPhone() + "#";
				sortedDataText += "email=" + staffInfoList.get(i).getEmail();

				if (staffInfoList.size() - i > 1) {
					sortedDataText += ", \n\n\n";
				}
			}
			
			sortedDataText += "]";
			
			System.out.println("TEXT DATA:  " + sortedDataText );
		}

		PrintWriter out = response.getWriter();
		out.print(sortedDataText);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}


