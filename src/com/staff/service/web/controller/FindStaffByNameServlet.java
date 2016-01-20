/**
 * 
 */
package com.staff.service.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.service.web.builders.ResponseBuilder;
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
		ResponseBuilder dataFormatResponse = new ResponseBuilder();
		String responseData = null;

		// Create instance of StaffDAO
		StaffInterface staffInterface = new StaffDAO();

		// Get staff member using name parameters sent over from the request
		Map<String, StaffInfo> staffInfoList = staffInterface.getStaffMemberByName(firstName, lastName);

		// Creates a JSON string that gets passed back to the client
		if (format.equalsIgnoreCase("json")) {

			responseData = dataFormatResponse.buildJsonResponse(staffInfoList);
			System.out.println("JSON DATA:  " + responseData);

		//Create XML and send back to User
		} else if (format.equalsIgnoreCase("xml")) {

			responseData = dataFormatResponse.buildXMLResponse(staffInfoList);
			System.out.println("XML DATA:  " + responseData);

			//Create Text Data and send back to client
		} else if (format.equalsIgnoreCase("string")) {

			responseData = dataFormatResponse.buildTextResponse(staffInfoList);
			System.out.println("TEXT DATA:  " + responseData);
		}

		//Send the response data back in the format required
		PrintWriter out = response.getWriter();
		out.print(responseData);
	}

	// GET data from server
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
