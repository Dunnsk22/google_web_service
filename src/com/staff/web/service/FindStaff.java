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
		List<StaffInfo> staffInfoList = StaffUtilities.findAllStaff();
		String format = request.getParameter("format");

		if (format.equalsIgnoreCase("json") ) {

			sortedDataText = "[ ";

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

			sortedDataText += "]";

			System.out.println("JSON DATA:  " + sortedDataText);

		} else if (format.equalsIgnoreCase("xml") ) {
			sortedDataText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sortedDataText += "<membersOfStaff>";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "<staffMember><id>" + staffInfoList.get(i).getStaffID() + "</id>";
				sortedDataText += "<forename>" + staffInfoList.get(i).getForename() + "</forename>";
				sortedDataText += "<surname>" + staffInfoList.get(i).getSurname() + "</surname>";
				sortedDataText += "<address>" + staffInfoList.get(i).getLocation() + "</address>";
				sortedDataText += "<phoneNumber>" + staffInfoList.get(i).getPhone() + "</phoneNumber>";
				sortedDataText += "<email>" + staffInfoList.get(i).getEmail() + "</email></staffMember>";

			}
			sortedDataText += "</membersOfStaff> \n \n";
			System.out.println("XML DATA:  " + sortedDataText);

		} else if (format.equalsIgnoreCase("string") ) {
			
			sortedDataText = "";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "" + staffInfoList.get(i).getStaffID() + "#||#";
				sortedDataText += "" + staffInfoList.get(i).getForename() + "#||#";
				sortedDataText += "" + staffInfoList.get(i).getSurname() + "#||#";
				sortedDataText += "" + staffInfoList.get(i).getLocation() + "#||#";
				sortedDataText += "" + staffInfoList.get(i).getPhone() + "#||#";
				sortedDataText += "" + staffInfoList.get(i).getEmail();

				if (staffInfoList.size() - i > 1) {
					sortedDataText += " " + "\n\n\n";
				}
			}
						
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


