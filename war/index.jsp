<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css" />
<script src="./scripts/ajax-utils.js" type="text/javascript"></script>
<script src="./scripts/ajax-basics-1.js" type="text/javascript"></script>

</head>

<body>
	<div align="center">
		<table border="5">
			<tr>
				<th class="title">Staff Web Service - Get Staff Data in XML, Json & Text</th>
			</tr>
		</table>
		<p />


		<fieldset>
			<form action="#">
				<legend>    Get All Staff   </legend>
				<br /> <label for="data-type">Retrieve Data in XML, Json or
					String:</label> <select id="format">
					<option value="xml" selected="selected">XML</option>
					<option value="json">JSON</option>
					<option value="string">Text</option>
				</select> <br /> <input type="button" value="Get Staff Details"
					onclick='getAllStaff("format", "all_staff")' />
			</form>
			<div id="all_staff"></div>
		</fieldset>


		<fieldset>
			<form action="#">
				<legend>Find Staff Members in Text or XML</legend>
				<label>First name: <input type="text" id="firstname" /> </label> 
				<br /> 
				<label>Last name: <input type="text" id="lastname" /></label>
				<br /> 
				<label for="data-type">Retrieve Data in XML, Json or String:</label> 
				<select id="individual">
					<option value="xml" selected="selected">XML</option>
					<option value="json">JSON</option>
					<option value="string">Text</option>
				</select> 
				<br /> 
				<input type="button" value="Get Staff Details"
					onclick='getStaffMember("firstname", "lastname", "individual", "staff_result")' />
			</form>
			<div id="staff_result"></div>
		</fieldset>
		
		
		<fieldset>
			<form action="#">
				<legend>Add Staff Members</legend>
				<label>First name: <input type="text" id="forename" /> </label> 
				<br /> 
				<label>Last name: <input type="text" id="surname" /></label>
				<br /> 
				<label>Email: <input type="text" id="email" /></label>
				<br /> 
				<label>Phone Number: <input type="text" id="phone_num" /></label>
				<br /> 
				<label>Address: <input type="text" id="address" /></label>
				<br /> 
				<input type="button" value="Add Staff"
					onclick='addStaffMember("forename", "surname", "email", "phone_num", "address", "staff_result_add")' />
			</form>
			<div id="staff_result_add"></div>
		</fieldset>

	</div>
	<br />
	<br />
	<br />
	<br />
</body>
</html>