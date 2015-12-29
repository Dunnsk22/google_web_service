<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script src="./scripts/ajax-utils.js" type="text/javascript"></script>
<script src="./scripts/ajax-basics-1.js" type="text/javascript"></script>
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
				<a class="navbar-brand" href="#">Staff Web Service - Joshua Dunn 12100434</a>
			</div>
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">

		<!-- Jumbotron Header -->
		<header class="jumbotron hero-spacer">
			<h2>Staff Web Service</h2>
			<p>Retrieve data in xml, json or text formats. Also, add Staff members to the google datastore.</p>
		</header>

		<hr>

		<!-- Title -->
		<div class="row">
			<div class="col-lg-12">
				<center><h3>Web Service Functions</h3></center>
			</div>
		</div>
		<!-- /.row -->

		<!-- Page Features -->
		<div class="row text-center">

			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
					<h3>Find All Staff</h3>
					<form action="#">
						<select id="format">
							<option value="xml" selected="selected">XML</option>
							<option value="json">JSON</option>
							<option value="string">Text</option>
						</select> <br /> <input type="button" value="Get Staff Details"
							onclick='getAllStaff("format", "result-region")' />
					</form>
				</div>
			</div>

			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
				  <h3>Find Member of Staff</h3>
					<form action="#">
						<label>First name: <input type="text" id="firstname" />
						</label> <br /> <label>Last name: <input type="text"
							id="lastname" /></label> <br /> <select id="individual">
							<option value="xml" selected="selected">XML</option>
							<option value="json">JSON</option>
							<option value="string">Text</option>
						</select> <br /> <input type="button" value="Get Staff Details"
							onclick='getStaffMember("firstname", "lastname", "individual", "result-region")' />
					</form>
				</div>
			</div>

			<div class="col-md-3 col-sm-6 hero-feature">
				<div class="thumbnail">
					<h3>Add a Member of Staff</h3>
					<form action="#">
						<label>First name: <input type="text" id="forename" />
						</label> <br /> <label>Last name: <input type="text" id="surname" /></label>
						<br /> <label>Email: <input type="text" id="email" /></label> <br />
						<label>Phone Number: <input type="text" id="phone_num" /></label>
						<br /> <label>Address: <input type="text" id="address" /></label>
						<br /> <input type="button" value="Add Staff"
							onclick='addStaffMember("forename", "surname", "email", "phone_num", "address", "staff_result_add")' />
					</form>
				</div>
			</div>
		</div>
		<hr>
		
		<!-- Response Region -->
		<center><h3>Results:</h3></center>
			<div id="result-region"></div>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12">
					<p>Joshua Dunn &copy; Staff Web Service - Enterprise Programming - 12100434</p>
				</div>
			</div>
		</footer>

	</div>
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>

</html>
