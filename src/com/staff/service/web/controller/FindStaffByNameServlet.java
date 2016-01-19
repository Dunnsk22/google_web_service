/**
 * 
 */
package com.staff.service.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.dao.StaffInterface;
import com.staff.service.web.model.StaffInfo;

@WebServlet("/FindStaffByName")
public class FindStaffByNameServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String format = request.getParameter("format");
		String sortedDataText = null;
		
		//Create instance of StaffDAO
		StaffInterface staffInterface = new StaffDAO();
		List<StaffInfo> staffInfoList = staffInterface.getStaffMemberByName(firstName, lastName);

		//Creates a JSON string that gets passed back to the client
		if (format.equalsIgnoreCase("json")) {

			sortedDataText = "[\n";

			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "\t{\n\t\t\"id\":" + "\""
						+ staffInfoList.get(i).getStaffID() + "\",\n";
				sortedDataText += "\t\t\"forename\":" + "\""
						+ staffInfoList.get(i).getForename() + "\",\n";
				sortedDataText += "\t\t\"surname\":" + "\""
						+ staffInfoList.get(i).getSurname() + "\",\n";
				sortedDataText += "\t\t\"address\":" + "\""
						+ staffInfoList.get(i).getLocation() + "\",\n";
				sortedDataText += "\t\t\"phone\":" + "\""
						+ staffInfoList.get(i).getPhone() + "\",\n";
				sortedDataText += "\t\t\"email\":" + "\""
						+ staffInfoList.get(i).getEmail() + "\"\n\t}\n";

				if (staffInfoList.size() - i > 1) {
					sortedDataText += ",";
				}
			}

			sortedDataText += "]";

			System.out.println("*** DEBUG *** JSON DATA:  " + sortedDataText);

			//Creates a XML String to be passed back to the client
		} else if (format.equalsIgnoreCase("xml")) {
			sortedDataText = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			sortedDataText = "<membersOfStaff>";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "\t<staffMember>\n";
				sortedDataText += "\t\t<id>"
						+ staffInfoList.get(i).getStaffID() + "</id>\n";
				sortedDataText += "\t\t<forename>"
						+ staffInfoList.get(i).getForename() + "</forename>\n";
				sortedDataText += "\t\t<surname>"
						+ staffInfoList.get(i).getSurname() + "</surname>\n";
				sortedDataText += "\t\t<address>"
						+ staffInfoList.get(i).getLocation() + "</address>\n";
				sortedDataText += "\t\t<phoneNumber>"
						+ staffInfoList.get(i).getPhone() + "</phoneNumber>\n";
				sortedDataText += "\t\t<email>"
						+ staffInfoList.get(i).getEmail() + "</email>\n";
				sortedDataText += "\t</staffMember>";
				sortedDataText += "\n";

			}
			sortedDataText += "</membersOfStaff>";
			System.out.println("XML DATA:  " + sortedDataText);

			//Creates a String to be passed back to the client
		} else if (format.equalsIgnoreCase("string")) {

			sortedDataText = "";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "" + staffInfoList.get(i).getStaffID()
						+ "#||#";
				sortedDataText += "" + staffInfoList.get(i).getForename()
						+ "#||#";
				sortedDataText += "" + staffInfoList.get(i).getSurname()
						+ "#||#";
				sortedDataText += "" + staffInfoList.get(i).getLocation()
						+ "#||#";
				sortedDataText += "" + staffInfoList.get(i).getPhone() + "#||#";
				sortedDataText += "" + staffInfoList.get(i).getEmail();

				if (staffInfoList.size() - i > 1) {
					sortedDataText += " " + "\n\n\n";
				}
			}

			System.out.println("TEXT DATA:  " + sortedDataText);
		}

		PrintWriter out = response.getWriter();
		out.print(sortedDataText);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
