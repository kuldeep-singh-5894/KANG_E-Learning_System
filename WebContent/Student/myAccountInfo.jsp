
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="kang.com.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grades</title>
<link rel="stylesheet" href="styles/myAccountInfo.css">
</head>
<body>
	<%@ include file="nav.jsp"%>
	<%
		Student s = (Student) request.getAttribute("s");
	%>
	<div id="table">
		<table id="nav">
			<tr>
				<th colspan=2>Account information</th>
			</tr>
			<tr>
				<td>Student ID</td>
				<td><%=s.getUnm()%></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><%=s.getFname()%></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><%=s.getLname()%></td>
			</tr>
			<tr>
				<td>Course</td>
				<td><%=s.getCourse()%></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><%=s.getGender()%></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><%=s.getOdob()%></td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td><%=s.getMs()%></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><%=s.getEmail()%></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><%=s.getPn()%></td>
			</tr>
			<tr>
				<td colspan=2><a href='Edit_Form?id=<%=s.getUnm()%>'>Edit
						Your Account Information</a></td>
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