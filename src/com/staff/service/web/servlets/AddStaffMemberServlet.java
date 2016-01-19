package com.staff.service.web.servlets;

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
 */
@WebServlet("/AddStaffMemberServlet")
public class AddStaffMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStaffMemberServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// GET xml parameters out of request
		String xml = request.getParameter("xml");
		PrintWriter out = response.getWriter();
		final String responseMessage = "A Staff Member has been successfully added to the GAE Datastore!";


		JAXBContext jaxbContext;
		StaffInfo staffMember = null;
		try {
			jaxbContext = JAXBContext.newInstance(StaffInfo.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			staffMember = (StaffInfo) unmarshaller.unmarshal(reader);
		} catch (JAXBException xmlParseException) {
			xmlParseException.printStackTrace();
		} 
		
		try {
			StaffInterface staffInterface = new StaffDAO();
			staffInterface.addStaffMember(staffMember);
			out.print(responseMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
