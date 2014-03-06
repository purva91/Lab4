<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="edu.asupoly.ser422.lab4.model.UserBean"%>
<%@page import="edu.asupoly.ser422.lab4.model.NewsItemBean"%>
<%@page import="edu.asupoly.ser422.lab4.dao.*"%>
<%@page import="java.util.*" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Story</title>
</head>
<body>
<%
	HttpSession aSession = request.getSession(false);
	String uname = (String) aSession.getAttribute("username");
	String role = (String) aSession.getAttribute("role");
	String loggedIn = (String) aSession.getAttribute("loggedIn");
	/* aSession.setAttribute("loggedIn",uname);
	aSession.setAttribute("username",uname);
	aSession.setAttribute("role",role);*/
%>
	<form name="addStory" action="addStory" method="post">		
    	Title: <input type="text" name="st_title" /> <br/><br>    
    	Story: <input type="text" name="st_desc" /> <br/><br>   
    	<input type="radio" name="access" value="subsonly">Subscribers Only<br/><br>  
		<input type="radio" name="access" value="public">Public<br/><br>  
    	<input type="submit" value="Add Story" /><br/><br>  
    	<input type="reset" value="Reset"/><br/><br>  
	</form>
	
	
</body>
</html>