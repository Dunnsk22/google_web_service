package com.staff.service.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.staff.service.web.model.StaffInfo;
import com.staff.web.service.StaffUtils;


/**
 * Servlet implementation class StaffDynamicStylingBuilder
 */
@WebServlet("/StaffDynamicStylingBuilder")
public class StaffDynamicStylingBuilder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffDynamicStylingBuilder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] staffIds = getIDs(request);
	    List<StaffInfo> staffMembers = new ArrayList<StaffInfo>();
	    for(String staffID: staffIds) {
	    	staffMembers.add(StaffUtils.getCustomerOrDefault(staffID));
	    }
	    response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
	    request.setAttribute("StaffMember", staffMembers);
	    String format = request.getParameter("format");
	    String outputPage;
	    if ("xml".equals(format)) {
	      response.setContentType("text/xml");
	      outputPage = "/WEB-INF/results/customers-xml.jsp";
	    } else if ("json".equals(format)) {
	      response.setContentType("text/javascript");
	      outputPage = "/WEB-INF/results/customers-json.jsp";
	    } else {
	      response.setContentType("text/plain");
	      outputPage = "/WEB-INF/results/customers-string.jsp";
	    }
	    RequestDispatcher dispatcher =
	      request.getRequestDispatcher(outputPage);
	    dispatcher.include(request, response);
	  }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	
	protected String[] getIDs(HttpServletRequest request) {
	    String[] ids = { "missing", "missing" };
	    for(int i=0; i<ids.length; i++) {
	      String id = request.getParameter("id" + (i+1));
	      if (!isEmpty(id)) { ids[i] = id; }
	    }
	    return(ids);
	  }
	  
	  private boolean isEmpty(String value) {
	    return((value == null) || (value.trim().equals("")));
	  }

}
