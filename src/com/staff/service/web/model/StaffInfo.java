/**
 * 
 */
package com.staff.service.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StaffInfo {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	String Surname, Forename, Address, Email, Phone;
	String StaffID;
	

	public StaffInfo(String staffID, String surname, String forename, String address, String phone, String email) {
		super();
		Surname = surname;
		Forename = forename;
		Address = address;
		Email = email;
		StaffID = staffID;
		Phone = phone;
	}
	
	public StaffInfo() {
		super();
		this.Surname = "";
		this.Forename = "";
		this.Address = "";
		this.Email = "";
		this.Phone = "";
		this.StaffID = "";

	}

	public String getStaffID() {
		return StaffID;
	}

	public void setStaffID(String staffID) {
		StaffID = staffID;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getForename() {
		return Forename;
	}

	public void setForename(String forename) {
		Forename = forename;
	}

	public String getLocation() {
		return Address;
	}

	public void setLocation(String location) {
		Address = location;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "StaffInfo [Surname=" + Surname + ", Forename=" + Forename + ", Address=" + Address + ", Email=" + Email
				+ ", StaffID=" + StaffID + ", Phone=" + Phone + "]";
	}

}
