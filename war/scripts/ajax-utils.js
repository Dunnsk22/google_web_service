// Get the browser-specific request object, either for
// Firefox, Safari, Opera, Mozilla, Netscape, IE 8, or IE 7 (top entry);
// or for Internet Explorer 5 and 6 (bottom entry). 

function getRequestObject() {
	if (window.XMLHttpRequest) {
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		// Don't throw Error: this part is for very old browsers,
		// and Error was implemented starting in JavaScript 1.5.
		return (null);
	}
}

// Generalized version of ajaxResultPost. In this
// version, you pass in a response handler function
// instead of just a result region.

function ajaxPost(address, data, responseHandler) {
	var request = getRequestObject();
	request.onreadystatechange = function() {
		responseHandler(request);
	};
	request.open("POST", address, true);
	request.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	request.send(data);
}

// Given an element, returns the body content.

function getBodyContent(element) {
	element.normalize();
	return (element.childNodes[0].nodeValue);
}

// Given a doc and the name of an XML element, returns an
// array of the values of all elements with that name.
// E.g., for
// <foo><a>one</a><q>two</q><a>three</a></foo>
// getXmlValues(doc, "a") would return
// ["one", "three"].

function getXmlValues(xmlDocument, xmlElementName) {
	var elementArray = xmlDocument.getElementsByTagName(xmlElementName);
	var valueArray = new Array();
	for (var i = 0; i < elementArray.length; i++) {
		valueArray[i] = getBodyContent(elementArray[i]);
	}
	return (valueArray);
}

function getElementValues(element, subElementNames) {
	var values = new Array(subElementNames.length);
	for (var i = 0; i < subElementNames.length; i++) {
		var name = subElementNames[i];
		var subElement = element.getElementsByTagName(name)[0];
		values[i] = getBodyContent(subElement);
	}
	return (values);
}

// Make an HTTP request to the given address.
// Display result in an alert box.

function ajaxAlert(address) {
	var request = getRequestObject();
	request.onreadystatechange = function() {
		showResponseAlert(request);
	};
	request.open("POST", address, true);
	request.send(null);
}

// Put response text in alert box.

function showResponseAlert(request) {
	if ((request.readyState == 4) && (request.status == 200)) {
		alert(request.responseText);
	}
}

// Make an HTTP request to the given address.
// Display result in the HTML element that has given ID.

function ajaxResult(address, resultRegion) {
	var request = getRequestObject();
	request.onreadystatechange = function() {
		showResponseText(request, resultRegion);
	};
	request.open("POST", address, true);
	request.send(null);
}

// Put response text in the HTML element that has given ID.

function showResponseText(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		htmlInsert(resultRegion, request.responseText);
	}
}

// Insert the html data into the element that has the specified id.

function htmlInsert(id, htmlData) {
	document.getElementById(id).innerHTML = htmlData;
}

// Trick so that the Firebug console.log function will
// be ignored (instead of crashing) in Internet Explorer.
// Also see Firebug Lite and Faux Console if you want
// logging to actually do something in IE.
// Firebug Lite: http://getfirebug.com/lite.html
// Faux Console: http://icant.co.uk/sandbox/fauxconsole/

try {
	console.log("Loading script");
} catch (e) {
	console = {
		log : function() {
		}
	};
}

// Return escaped value of textfield that has given id.
// The builtin "escape" function converts < to &lt;, etc.

function getValue(id) {
	return (escape(document.getElementById(id).value));
}

function getTable(headings, rows) {
	var table = "<table border='1' class='ajaxTable'>\n"
			+ getTableHeadings(headings) + getTableBody(rows) + "</table>";
	return (table);
}

function getTableHeadings(headings) {
	var firstRow = "  <tr>";
	for (var i = 0; i < headings.length; i++) {
		firstRow += "<th>" + headings[i] + "</th>";
	}
	firstRow += "</tr>\n";
	return (firstRow);
}

function getTableBody(rows) {
	var body = "";
	for (var i = 0; i < rows.length; i++) {
		body += "  <tr>";
		var row = rows[i];
		for (var j = 0; j < row.length; j++) {
			body += "<td>" + row[j] + "</td>";
		}
		body += "</tr>\n";
	}
	return (body);
}

// Get the browser-specific request object, either for
// Firefox, Safari, Opera, Mozilla, Netscape, or IE 7 (top entry);
// or for Internet Explorer 5 and 6 (bottom entry).

function getRequestObject() {
	if (window.XMLHttpRequest) {
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		return (null);
	}
}

// Insert the html data into the element
// that has the specified id.

function htmlInsert(id, htmlData) {
	document.getElementById(id).innerHTML = htmlData;
}

// Return escaped value of textfield that has given id.
// The builtin "escape" function url-encodes characters.

function getValue(id) {
	return (escape(document.getElementById(id).value));
}

// Generalized version of ajaxResultPost. In this
// version, you pass in a response handler function
// instead of just a result region.

function ajaxPost(address, data, responseHandler) {
	var request = getRequestObject();
	request.onreadystatechange = function() {
		responseHandler(request);
	};
	request.open("POST", address, true);
	request.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	request.send(data);
}

// Given an element, returns the body content.

function getBodyContent(element) {
	element.normalize();
	return (element.childNodes[0].nodeValue);
}

// Given a doc and the name of an XML element, returns an
// array of the values of all elements with that name.
// E.g., for
// <foo><a>one</a><q>two</q><a>three</a></foo>
// getXmlValues(doc, "a") would return
// ["one", "three"].

function getXmlValues(xmlDocument, xmlElementName) {
	var elementArray = xmlDocument.getElementsByTagName(xmlElementName);
	var valueArray = new Array();
	for (var i = 0; i < elementArray.length; i++) {
		valueArray[i] = getBodyContent(elementArray[i]);
	}
	return (valueArray);
}

// Given an element object and an array of sub-element names,
// returns an array of the values of the sub-elements.
// E.g., for <foo><a>one</a><c>two</c><b>three</b></foo>,
// if the element points at foo,
// getElementValues(element, ["a", "b", "c"]) would return
// ["one", "three", "two"]

function getElementValues(element, subElementNames) {
	var values = new Array(subElementNames.length);
	for (var i = 0; i < subElementNames.length; i++) {
		var name = subElementNames[i];
		var subElement = element.getElementsByTagName(name)[0];
		values[i] = getBodyContent(subElement);
	}
	return (values);
}

// Takes as input an array of headings (to go into th elements)
// and an array-of-arrays of rows (to go into td
// elements). Builds an xhtml table from the data.

function getTable(headings, rows) {
	var table = "<table border='1' class='ajaxTable'>\n"
			+ getTableHeadings(headings) + getTableBody(rows) + "</table>";
	return (table);
}

function getTableHeadings(headings) {
	var firstRow = "  <tr>";
	for (var i = 0; i < headings.length; i++) {
		firstRow += "<th>" + headings[i] + "</th>";
	}
	firstRow += "</tr>\n";
	return (firstRow);
}

function getTableBody(rows) {
	var body = "";
	for (var i = 0; i < rows.length; i++) {
		body += "  <tr>";
		var row = rows[i];
		for (var j = 0; j < row.length; j++) {
			body += "<td>" + row[j] + "</td>";
		}
		body += "</tr>\n";
	}
	return (body);
}