/**
 * 
 */
package com.staff.web.service;

import com.staff.service.web.model.StaffInfo;


/** Some helper utilities for making Strings describing customers. */

public class ResultUtils {
	/**
	 * makeBulletedList returns an HTML ul list describing the Customer,
	 * suitable for inserting into the page.
	 */

	public static String makeBulletedList(StaffInfo staff) {
		String list = "<ul>\n" + makeBullet("First name", staff.getForename())
				+ makeBullet("Last name", staff.getSurname())
				+ makeBullet("Address", staff.getLocation()) + "</ul>\n";
		return (list);
	}

	private static String makeBullet(String prompt, String value) {
		return (String.format("  <li>%s: %s</li>\n", prompt, value));
	}

	public static String makeErrorMessage(String itemName) {
		String message = String.format(
				"<h2 class='error'>Missing or Invalid %s</h2>", itemName);
		return (message);
	}

	public static String buildXmlData(StaffInfo staffMember) {
		String createXML = "&lt;StaffMembers&gt;&lt;Staff&gt&lt;Forename&gt;"
				+ staffMember.getForename() + "&lt;/Forename&gt&lt;Surname&gt;"
				+ staffMember.getSurname() + "&lt;/Surname&gt&lt;Address&gt"
				+ staffMember.getLocation()
				+ "&lt;/Address&gt&lt;/Staff&gt&lt;/StaffMembers&gt \n";
		return createXML;
	}
}
