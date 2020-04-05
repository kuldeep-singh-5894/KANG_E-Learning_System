<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<! DOCTYPE html>

<html>
<head>
<title>KANG Sign In</title>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles/sign_in.css">
</head>

<body>
	<marquee> Welcome to our KANG E-learning System</marquee>

	<h1 id="head">Welcome to KANG E-learning System</h1>
	<div id="table">
		<div style="padding: 5px" class="column">
			<%if(request.getAttribute("error")!=null){ %>
			<%=request.getAttribute("error") %>
			<% } %>
			<form action="Student_login" method="post">
				<table>
					<tr>
						<td><label> Student_Id :</label></td>
					</tr>
					<tr>
						<td><input type="text" name="id" id="uname" class="name"
							max="25" placeholder="Enter Your Student ID" required></td>
					</tr>
					<tr>
						<td><label> Password :</label></td>
					</tr>
					<tr>
						<td><input type="password" name="pswd" id="pswd" class="name"
							max="25" placeholder="Enter your password here" required>
						</td>
					</tr>
				</table>
				<input type="submit" class="sub" value="Sign-In"><br>
				<br>
				<p>Don't have Account?</p>
				<a href='s_sign_up.html' class="sub">Sign Up Here</a>
			</form>
		</div>
		<div class="column">
			<img src="images/std.jpg" class="limg" alt="Student"><br>
		</div>

	</div>
<body>

	<footer>
		<a href="#top" class="sign_in"><h2 id="btt">Back to Top</h2></a>
		<h2>E-Learning System</h2>
		<h2>Copyright&copy;by KANG Group #5 2020</h2>
	</footer>
</html>