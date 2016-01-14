/**
 * 
 */
package com.staff.web.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.staff.service.web.model.StaffInfo;


public class FindStaffByName extends FindStaffByID {
	  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String firstName = request.getParameter("firstname");
	    String lastName = request.getParameter("lastname");
	    String format = request.getParameter("format");
	    String sortedDataText = null;
	   	    
	    List<StaffInfo> staffInfoList = StaffUtils.getNamedCustomer(firstName, lastName);

	    if (format.equalsIgnoreCase("json") ) {

			sortedDataText = "[ ";

			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "{\" id\":" + "\"" + staffInfoList.get(i).getStaffID() + "\",";
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
			sortedDataText = "<membersOfStaff>";
			for (int i = 0; i < staffInfoList.size(); i++) {

				sortedDataText += "<staffMember>\n\n \t \t<id>" + staffInfoList.get(i).getStaffID() + "</id>\n";
				sortedDataText += "<forename>" + staffInfoList.get(i).getForename() + "</forename>";
				sortedDataText += "<surname>" + staffInfoList.get(i).getSurname() + "</surname>";
				sortedDataText += "<address>" + staffInfoList.get(i).getLocation() + "</address>";
				sortedDataText += "<phoneNumber>" + staffInfoList.get(i).getPhone() + "</phoneNumber>";
				sortedDataText += "<email>" + staffInfoList.get(i).getEmail() + "</email></staffMember>";

			}
			sortedDataText += "</membersOfStaff> \n \n";
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
	}

