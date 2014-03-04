<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="edu.asupoly.ser422.lab4.model.UserBean"%>
<%@page import="edu.asupoly.ser422.lab4.dao.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register user</title>
</head>
<body>
<%
	HttpSession aSession = request.getSession();
	String uname = (String) aSession.getAttribute("username");
	String passwd= (String) aSession.getAttribute("password");
%>
<p>You are not registered. Enter Role to register</p>
<form name="register" action="register" method="post">
    Username: <input type="text" name="username" value=<%= uname %> /> <br/>
    Password: <input type="password" name="password" value=<%= passwd %> /> <br/>
    Role: <input type="text" name="role" /> <br/>
    
    <input type="submit" value="Register" />
    
    <a href="./index.html">Back</a>
  </form>
</body>
</html>
</body>
</html>