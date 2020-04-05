
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="kang.com.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grades</title>
<link rel="stylesheet" href="styles/myGrades.css">
</head>
<body>
	<%@ include file="nav.jsp"%>
	<%
		Student s = (Student) request.getAttribute("s");
	%>
	<div id="table">
		<table id="nav">
			<tr>
				<th>Activity</th>
				<th>Grade</th>
			</tr>
			<tr>
				<td>Assignment 1</td>
				<td><%= s.getA1() %></td>
			</tr>
			<tr>
				<td>Assignment 2</td>
				<td><%= s.getA2() %></td>
			</tr>
			<tr>
				<td>Assignment 3</td>
				<td><%= s.getA3() %></td>
			</tr>
			<tr>
				<td>Assignment 4</td>
				<td><%= s.getA4() %></td>
			</tr>
			<tr>
				<td>Assignment 5</td>
				<td><%= s.getA5() %></td>
			</tr>
			<tr>
				<td>Test 1</td>
				<td><%= s.getT1() %></td>
			</tr>
			<tr>
				<td>Test 2</td>
				<td><%= s.getT2() %></td>
			</tr>
			<tr>
				<td>Test 3</td>
				<td><%= s.getT3() %></td>
			</tr>
		</table>
	</div>
<body>

	<footer> <a href="#top" class="sign_in"><h2 id="btt">Back
			to Top</h2></a>
	<h2>E-Learning System</h2>
	<h2>Copyright&copy;by KANG Group #5 2020</h2>
	</footer>
</html>