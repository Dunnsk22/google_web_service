function getAllStaff(inputField, resultRegion) {
	var web_xml_address = "find-all-staff";
	var data = "format=" + getValue(inputField);
	var address = web_xml_address + "?" + data;
	ajaxResult(address, resultRegion);
}

function getStaffMember(firstname, lastname, format, resultRegion) {
	var web_xml_address = "find-staff-member";
	var data = "format=" + getValue(format) + "&firstname="
			+ getValue(firstname) + "&lastname=" + getValue(lastname);
	var address = web_xml_address + "?" + data;
	ajaxResult(address, resultRegion);
}

function addStaffMember(firstname, lastname, address, phone_num, email, resultRegion) {
	var web_xml_address = "add-staff-member";
	var data = "forename="
			+ getValue(firstname) + "&surname=" + getValue(lastname) + "&address=" + getValue(address)
			+ "&phone_num=" + getValue(phone_num) + "&email=" + getValue(email);
	var address = web_xml_address + "?" + data;
	ajaxResult(address, resultRegion);
}
