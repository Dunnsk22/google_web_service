<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="./scripts/ajax-utility-functions.js" type="text/javascript"></script>
<script src="./scripts/ajax-functions-1.js" type="text/javascript"></script>
<title>Heroic Features - Start Bootstrap Template</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/heroic-features.css" rel="stylesheet">
<link href="css/override.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="http://1-dot-corded-backbone-118916.appspot.com/">Go to
					Staff RESTful Service!</a>

			</div>
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- <!-- Jumbotron Header -->
		<header class="jumbotron hero-spacer"
			style="padding-top: inherit; margin-top: auto;">
			<h2>Staff Web Service</h2>
			<p>Retrieve data in xml, json or text formats. Also, add Staff
				members to the google datastore. Please scroll down to use the Web
				Service functions. Please select the data type you want the server to respond with from the drop down lists.</p>
		</header>

		<hr>

		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<center>
					<h2>Web Service Functions</h2>
				</center>
			</div>
		</div>
		<!-- /.row -->

		<!-- Page Features -->
		<div class="row text-center">

			<div class="col-md-3 col-sm-6 hero-feature" align="center">
				<div class="thumbnail">
					<h3>Find All Staff</h3>
					<form action="#">
						<select id="format">
							<option value="json" selected="selected">JSON</option>
							<option value="xml">XML</option>
							<option value="string">Text</option>
						</select> <br />
						<!-- <input type="button" value="Get Staff Details"
							onclick='getAllStaff("format", "result-region")' /> -->

						<button type="button" class="btn btn-primary"
							onclick='getAllStaff("format", "result-region")'
							style="margin-top: 10px !important;">Get All Staff</button>


					</form>
				</div>
			</div>
		</div>

		<div class="row text-center">
			<div class="col-md-3 col-sm-6 hero-feature" align="center">
				<div class="thumbnail">
					<h3>Find Member of Staff</h3>
					<form action="#">
						<label>Last name: <input type="text" id="firstname" />
						</label> <br /> <label>First name: <input type="text"
							id="lastname" /></label> <br /> <select id="individual">
							<option value="json" selected="selected">JSON</option>
							<option value="xml">xml</option>
							<option value="string">Text</option>
						</select> <br />
						<!-- <input type="button" value="Get Staff Details"
							onclick='getStaffMember("firstname", "lastname", "individual","result-region" )' /> -->

						<button type="button" class="btn btn-primary"
							onclick='getStaffMember("firstname", "lastname", "individual","result-region" )'
							style="margin-top: 10px !important">Get Staff Member
							Staff</button>
					</form>
				</div>
			</div>
		</div>

		<div class="row text-center">
			<div class="col-md-3 col-sm-6 hero-feature" align="center">
				<div class="thumbnail">
					<h3>Add a Member of Staff</h3>
					<form action="#">
						<label>First name: <input type="text" id="forename" />
						</label> <br /> <label>Last name: <input type="text" id="surname" /></label>
						<br /> <label>Email: <input type="text" id="email" /></label> <br />
						<label>Phone: <input type="text" id="phone_num" /></label> <br />
						<label>Location: <input type="text" id="address" /></label> <br />
						<!-- <input type="button" onclick='addStaffMember("forename", "surname", "address", "phone_num", "email", "staff_result_add")' /> -->
						<button type="button" class="btn btn-primary"
							onclick='addStaffMember("forename", "surname", "address", "phone_num", "email", "staff_result_add")'
							margin-top="10px !important">Add Staff Member</button>
					</form>
				</div>
			</div>
		</div>
		<hr>

		<!-- Response Region -->
		<center>
			<h3>Results:</h3>
		</center>
		<div id="result-region"></div>

		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>


<!-- Internal Styling for the Dynamically Generated Table  -->
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th {
	background-color: #e4e7e5;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5
}
</style>

</html>
