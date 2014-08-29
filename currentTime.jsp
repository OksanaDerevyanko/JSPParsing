<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>Current Time</title>
</head>
<body>
	<center>
		<h2>Hello!</h2>
		<p>This simple page shows current time.</p>
		<img alt="Clock"
			src="http://www.dumblittleman.com/wp-content/uploads/2014/04/Time-Management-Tips.jpg"
			width="300"/>
		<br/>
		<h3>Current time is:</h3>
		<% Date date = new Date(); out.println(date); %>
	</center>
</body>
</html>