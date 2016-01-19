package com.staff.service.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.dao.StaffInterface;
import com.staff.service.web.model.StaffInfo;

/**
 * Servlet implementation class AddStaffMemberServlet
 * Adds data to the GAE datastore
 * Parses xml input from the request
 */
@WebServlet("/AddStaffMemberServlet")
public class AddStaffMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStaffMemberServlet() {
		super();
	}

	//POST data to the server if there is a GET request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	// Always POST data to GAE Datastore
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Create JAXB object to parse XML data from the request
		JAXBContext jaxbContext;

		// GET xml parameters out of request
		String xml = request.getParameter("xml");

		PrintWriter out = response.getWriter();
		final String responseMessage = "A Staff Member has been successfully added to the GAE Datastore!";

		StaffInfo staffMember = null;
		
		/*
		 * Tries to create a JAXBContext instance with the StaffInfo Class
		 * and then parse the xml sent in from the request
		 * 
		 * @param xml - request data sent from client
		 * @param reader - reads the xml and passed to the Unmarshaller object
		 */
		try {
			jaxbContext = JAXBContext.newInstance(StaffInfo.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			staffMember = (StaffInfo) unmarshaller.unmarshal(reader);
		}

		catch (JAXBException xmlParseException) {
			//Catches JAXB Exception
			xmlParseException.printStackTrace();
		}

		/*
		 * Creates an instance of the DAO class from the StaffInterface
		 * and then adds the parsed xml data
		 * @param - staffMember
		 * 
		 */
		try {
			StaffInterface staffInterface = new StaffDAO();
			staffInterface.addStaffMember(staffMember);
			out.print(responseMessage);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
