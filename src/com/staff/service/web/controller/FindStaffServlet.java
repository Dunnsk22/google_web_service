/**
 * 
 */
package com.staff.service.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.dao.StaffInterface;
import com.staff.service.web.model.StaffInfo;

public class FindStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sortedDataText = null;
		String format = request.getParameter("format");
		StaffInterface staffInterface = new StaffDAO();
		Map<String, StaffInfo> staffInfoList = staffInterface.getStaffMembers();
		List<StaffInfo> staffInfo = new ArrayList<>();

		for (StaffInfo info : staffInfoList.values()) {
			staffInfo.add(info);
		}

		if (format.equalsIgnoreCase("json")) {

			sortedDataText = "[ ";

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

			sortedDataText += "]";

			System.out.println("JSON DATA:  " + sortedDataText);

		} else if (format.equalsIgnoreCase("xml")) {
			sortedDataText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sortedDataText = "\n";
			sortedDataText += "<membersOfStaff>\n";
			for (int i = 0; i < staffInfo.size(); i++) {

				sortedDataText += "\t<staffMember>\n";
				sortedDataText += "\t\t<id>"
						+ staffInfo.get(i).getStaffID() + "</id>\n";
				sortedDataText += "\t\t<forename>"
						+ staffInfo.get(i).getForename() + "</forename>\n";
				sortedDataText += "\t\t<surname>"
						+ staffInfo.get(i).getSurname() + "</surname>\n";
				sortedDataText += "\t\t<address>"
						+ staffInfo.get(i).getLocation() + "</address>\n";
				sortedDataText += "\t\t<phoneNumber>"
						+ staffInfo.get(i).getPhone() + "</phoneNumber>\n";
				sortedDataText += "\t\t<email>"
						+ staffInfo.get(i).getEmail() + "</email>\n";
				sortedDataText += "\t</staffMember>";
				sortedDataText += "\n";

			}
			sortedDataText += "</membersOfStaff>";
			System.out.println("XML DATA:  " + sortedDataText);

		} else if (format.equalsIgnoreCase("string")) {

			sortedDataText = "";
			for (int i = 0; i < staffInfo.size(); i++) {

				sortedDataText += "" + staffInfo.get(i).getStaffID()
						+ "#||#";
				sortedDataText += "" + staffInfo.get(i).getForename()
						+ "#||#";
				sortedDataText += "" + staffInfo.get(i).getSurname()
						+ "#||#";
				sortedDataText += "" + staffInfo.get(i).getLocation()
						+ "#||#";
				sortedDataText += "" + staffInfo.get(i).getPhone() + "#||#";
				sortedDataText += "" + staffInfo.get(i).getEmail();

				if (staffInfo.size() - i > 1) {
					sortedDataText += " " + "\n\n\n";
				}
			}

			System.out.println("TEXT DATA:  " + sortedDataText);
		}

		PrintWriter out = response.getWriter();
		out.print(sortedDataText);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
