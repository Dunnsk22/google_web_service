package com.staff.service.web.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.service.web.model.StaffInfo;
import com.staff.web.service.AddStaffMember;


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
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forename = request.getParameter("forename");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_num");

		System.out.println("Forename is " + forename);
		StaffInfo staffMember = new StaffInfo();

		staffMember.setStaffID("102");
		staffMember.setForename(forename);
		staffMember.setSurname(surname);
		staffMember.setLocation(address);
		staffMember.setPhone(phone);
		staffMember.setEmail(email);

		AddStaffMember addStaffMember = new AddStaffMember();
		try {
			addStaffMember.addStaffMember(staffMember);
			System.out.println(" Member added ");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(" Errorr ");

		}
	}

}
