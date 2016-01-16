package com.staff.service.web.servlets;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Response;

import com.staff.service.web.dao.StaffDAO;
import com.staff.service.web.model.StaffInfo;

/**
 * Servlet implementation class AddStaffMemberServlet
 */
@WebServlet("/AddStaffMemberServlet")
public class AddStaffMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStaffMemberServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get parameters to be passed to StaffInfo Object
		String xml = request.getParameter("xml");
		System.out.println("Data is " + xml);

		JAXBContext jaxbContext;
		StaffInfo staffMember = null;
		try {
			jaxbContext = JAXBContext.newInstance(StaffInfo.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			staffMember = (StaffInfo) unmarshaller.unmarshal(reader);

			System.out.println("The staff data is : " + staffMember.toString());

		} catch (JAXBException e1) {
			e1.printStackTrace();
		}

		// Create StaffInfo object to access its methods
		// StaffInfo staffMember = new StaffInfo();
		// staffMember.setForename(staffMember.getForename());
		// staffMember.setSurname(staffMember.getSurname());
		// staffMember.setLocation(staffMember.getLocation());
		// staffMember.setPhone(staffMember.getPhone());
		// staffMember.setEmail(staffMember.getEmail());

		try {
			StaffDAO.addStaffMember(staffMember);
			System.out.println(" Member added " + staffMember);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Errorr ");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
