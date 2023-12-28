<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee registration</title>
<script>
        function validateForm() {
            var firstName = document.forms["registrationForm"]["firstName"].value;
            var lastName = document.forms["registrationForm"]["lastName"].value;
            var userName = document.forms["registrationForm"]["userName"].value;
            var password = document.forms["registrationForm"]["password"].value;
            var city = document.forms["registrationForm"]["city"].value;
            var state = document.forms["registrationForm"]["state"].value;
            var contact = document.forms["registrationForm"]["contact"].value;

            if (firstName === "" || lastName === "" || userName === "" || password === "" || city === "" || state === "" || contact === "") {
                alert("All fields must be filled out");
                return false;
            }
        }
    </script>
</head>
<body>
	<div align="center">
		<h1>Employee Register Form</h1>
		<form name="registrationForm" action="<%=request.getContextPath()%>/register" method="post" onsubmit="return validateForm()">
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" name="city" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><input type="text" name="state" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contact" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>