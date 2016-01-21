/**
 * 
 */
package com.staff.service.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.service.web.builders.ResponseBuilder;
import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.dao.StaffInterface;
import com.staff.service.web.model.StaffInfo;

public class FindStaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String format = request.getParameter("format");
		StaffInterface staffInterface = new StaffDAO();
		Map<String, StaffInfo> staffInfoList = staffInterface.getStaffMembers();
		ResponseBuilder dataFormatResponse = new ResponseBuilder();
		String responseData = null;
		

		if (format.equalsIgnoreCase("json")) {
			
			responseData = dataFormatResponse.buildJsonResponse(staffInfoList);
			System.out.println("JSON DATA:  " + responseData);
			
		} else if (format.equalsIgnoreCase("xml")) {
			
			responseData = dataFormatResponse.buildXMLResponse(staffInfoList);
			System.out.println("XML DATA:  " + responseData);

		} else if (format.equalsIgnoreCase("string")) {

			responseData = dataFormatResponse.buildTextResponse(staffInfoList);
			System.out.println("TEXT DATA:  " + responseData);
		}

		PrintWriter out = response.getWriter();
		out.print(responseData);

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
