function getAllStaff(inputField, resultRegion) {
	var web_xml_address = "find-all-staff";
	var data = "format=" + getValue(inputField);
	var format = getValue(inputField);
	var address = web_xml_address + "?" + data;
	if (format == "json") {
		ajaxPost(address, data, function(request) {
			showJsonCustomerInfo(request, resultRegion);
		});
	} else if (format == "xml") {
		ajaxPost(address, data, function(request) {
			showXmlCustomerInfo(request, resultRegion);
		});
	} else if (format == "string") {
		ajaxPost(address, data, function(request) {
			showStringCustomerInfo(request, resultRegion);
		});
	}
}

function getStaffMember(firstname, lastname, format, resultRegion) {
	var web_xml_address = "find-staff-member";
	var firstname = getValue(firstname);
	var lastname = getValue(lastname);
	var format = getValue(format);
	var data = "firstname=" + firstname + "&lastname=" + lastname + "&format=" + format;
	var address = web_xml_address + "?" + data;
	if (format == "json") {
		ajaxPost(address, data, function(request) {
			showJsonCustomerInfo(request, resultRegion);
		});
	} else if (format == "xml") {
		ajaxPost(address, data, function(request) {
			showXmlCustomerInfo(request, resultRegion);
		});
	} else if (format == "string") {
		ajaxPost(address, data, function(request) {
			showStringCustomerInfo(request, resultRegion);
		});
	}

}

function addStaffMember(firstname, lastname, address, phone, email,resultRegion) {
	var web_xml_address = "add-staff-member";
	var xmlData = "xml=" + "<staffInfo><forename>" + getValue(firstname)
			+ "</forename>" + "<surname>" + getValue(lastname) + "</surname>"
			+ "<email>" + getValue(email) + "</email>" + "<phone>"
			+ getValue(phone) + "</phone>" + "<location>" + getValue(address)
			+ "</location>" + "</staffInfo>";
	var address = web_xml_address + "?" + xmlData;
	console.log(xmlData);
	ajaxResult(address, resultRegion);
}

function getCustomerTable(rows) {
	var headings = [ "Customer ID", "Last Name", "First Name", "Address",
			"Phone", "Email" ];
	return (getTable(headings, rows));
}

function xmlCustomerTable(resultRegion, field1, field2) {
	var address = "find-staff-member";
	var data = makeParamString(field1, field2, "xml");
	ajaxPost(address, data, function(request) {
		showXmlCustomerInfo(request, resultRegion);
	});
}

function showXmlCustomerInfo(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		var xmlDocument = request.responseXML;
		var customers = xmlDocument.getElementsByTagName("staffMember");
		var rows = new Array();
		for (var i = 0; i < customers.length; i++) {
			var customer = customers[i];
			var subElements = [ "id", "forename", "surname", "address",
					"phoneNumber", "email" ];
			rows[i] = getElementValues(customer, subElements);
		}
		var table = getCustomerTable(rows);
		htmlInsert(resultRegion, table);
	}
}

function showResponseMessage(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		var re
	}
}

function jsonCustomerTable(resultRegion, field1, field2) {
	var address = "show-customers";
	var data = makeParamString(field1, field2, "json");
	ajaxPost(address, data, function(request) {
		showJsonCustomerInfo(request, resultRegion);
	});
}

function showJsonCustomerInfo(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		var rawData = request.responseText;
		var staffData = eval("(" + rawData + ")");
		var rows = new Array();
		for (var i = 0; i < staffData.length; i++) {
			var staff = staffData[i];
			rows[i] = [ staff.id, staff.forename, staff.surname, staff.address,
					staff.phone, staff.email ];
		}
		var table = getCustomerTable(rows);
		htmlInsert(resultRegion, table);
	}
}

// function stringCustomerTable(resultRegion, field1, field2) {
// var address = "show-customers";
// var data = makeParamString(field1, field2, "string");
// ajaxPost(address, data, function(request) {
// showStringCustomerInfo(request, resultRegion);
// });
// }

function showStringCustomerInfo(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		var rawData = request.responseText;
		var customers = rawData.split(/\n+/);
		var rows = new Array();
		for (var i = 0; i < customers.length; i++) {
			if (customers[i].length > 1) { // Ignore blank lines
				rows.push(customers[i].split("#||#"));
			}
		}
		var table = getCustomerTable(rows);
		htmlInsert(resultRegion, table);
	}
}

function makeParamString(id1, id2, format) {
	var paramString = "id1=" + getValue(id1) + "&id2=" + getValue(id2)
			+ "&format=" + format;
	return (paramString);
}
