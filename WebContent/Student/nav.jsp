<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<marquee> Welcome to our KANG E-learning System</marquee>

	<h1 id="head">Welcome to KANG E-learning System</h1>
	<nav id="hnav"> <a
		href='Student_Home?id=<%=request.getParameter("id")%>'>Home</a> <a
		href='StudyMaterial?id=<%=request.getParameter("id")%>'>Study
		Material</a> <a href='GetStudentById?id=<%=request.getParameter("id")%>'>Account
		Information</a> <a href=GetGradesById?id=<%=request.getParameter("id")%>>Grades</a> <a href='Logout'>Logout</a></nav>
</body>
</html>