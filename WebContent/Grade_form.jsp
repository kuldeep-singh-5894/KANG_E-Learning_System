<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grades Form</title>
<link rel="stylesheet" type="text/css" href="styles/Grade_form.css">
</head>

<marquee> Welcome to our KANG E-learning System</marquee>
<body>
	<h1 id='head'>Student Information Editing Form</h1>

	<div class='sub_form'>
		<h2>Please fill the information for updating Student Account</h2>
		<br> <br>
		<form action="Set_Grade?id=<%=request.getParameter("id")%>"
			method='post'>
			<table>
				<tr>
					<td><label> Assignment 1 :</label></td>
					<td><input type="text" name="a1" id="uname" class="name"
						max="25" placeholder="Assignment 1" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Assignment 2 :</label></td>
					<td><input type="text" name="a2" id="uname" class="name"
						max="25" placeholder="Assignment 2" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Assignment 3 :</label></td>
					<td><input type="text" name="a3" id="uname" class="name"
						max="25" placeholder="Assignment 3" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Assignment 4 :</label></td>
					<td><input type="text" name="a4" id="uname" class="name"
						max="25" placeholder="Assignment 4" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Assignment 5 :</label></td>
					<td><input type="text" name="a5" id="uname" class="name"
						max="25" placeholder="Assignment 5" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Test 1 :</label></td>
					<td><input type="text" name="t1" id="uname" class="name"
						max="25" placeholder="Assignment 1" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Test 2 :</label></td>
					<td><input type="text" name="t2" id="uname" class="name"
						max="25" placeholder="Assignment 1" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>
				<tr>
					<td><label> Test 3 :</label></td>
					<td><input type="text" name="t3" id="uname" class="name"
						max="25" placeholder="Assignment 1" pattern="([-+ A-F]){1,2}"
						title="(+-)(A-F)" required></td>
				</tr>


			</table>
			<input type="submit" class="sub" value="Submit">
		</form>
	</div>
<body>
	<footer> <a href='#top' class='sign_in'><h2 id='btt'>Back
			to Top</h2></a>
	<h2>E-Learning System</h2>
	<h2>Copyright&copy;by KANG Group #5 2020</h2>
	</footer>
</html>