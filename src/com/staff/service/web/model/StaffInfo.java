/**
 * 
 */
package com.staff.service.web.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "staffID", "surname", "forename", "address", "phone", "email" })
public class StaffInfo {
	String Surname, Forename, Address, Email, Phone;
	String StaffID;
	
	public StaffInfo() 
	{
		super();
	}
	
	public StaffInfo(String staffID, String surname, String forename, String address, String phone, String email) 
	{
		super();
		Surname = surname;
		Forename = forename;
		Address = address;
		Email = email;
		StaffID = staffID;
		Phone = phone;
	}
	
	
	
	public StaffInfo(StaffInfo staffInfo) {
		// TODO Auto-generated constructor stub
	}


	/*
	 * @return staff_id to be used when accessing data
	 */
	public String getStaffID() 
	{
		return StaffID;
	}

	/*
	 * @param staffID - The staff ID that identifies the staff member
	 */
	public void setStaffID(String staffID) 
	{
		StaffID = staffID;
	}

	/*
	 * @return surname of Staff Member
	 */
	public String getSurname() 
	{
		return Surname;
	}

	/*
	 * @param surname - sets staff member surname
	 */
	public void setSurname(String surname) {
		Surname = surname;
	}

	/*
	 * @return forename - returns staff member forename
	 */
	public String getForename() {
		return Forename;
	}

	/*
	 * @param forename - sets staff forename
	 */
	public void setForename(String forename) {
		Forename = forename;
	}

	/*
	 * @return Address - Returns a staff members address
	 */
	public String getLocation() {
		return Address;
	}

	/*
	 * @param location - sets staff member address
	 */
	public void setLocation(String location) {
		Address = location;
	}

	/*
	 * @return Phone - returns users phone num
	 */
	public String getPhone() {
		return Phone;
	}

	/*
	 * @param Phone - sets staff phone number
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	/*
	 * @return Email - returns the staff member email address
	 */
	public String getEmail() {
		return Email;
	}

	/*
	 * @param Email - Sets a staff member' email
	 */
	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "StaffInfo [Surname=" + Surname + ", Forename=" + Forename + ", Address=" + Address + ", Email=" + Email
				+ ", StaffID=" + StaffID + ", Phone=" + Phone + "]";
	}

}
