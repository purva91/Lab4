<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="edu.asupoly.ser422.lab4.model.UserBean"%>
<%@page import="edu.asupoly.ser422.lab4.model.NewsItemBean"%>
<%@page import="edu.asupoly.ser422.lab4.dao.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Full Story</title>
</head>
<body>
	<%
	HttpSession aSession = request.getSession(false);
	String uname = (String) aSession.getAttribute("username");
	String loggedIn = (String) aSession.getAttribute("loggedIn");
	String role = (String) aSession.getAttribute("role");
	if(loggedIn == null){
		out.println("Gone!!");
	}
	NewsItemBean[] news = (NewsItemBean[]) aSession.getAttribute("newsList");
	int newsID =Integer.parseInt(request.getParameter("newsID"));
	aSession.setAttribute("loggedIn",loggedIn);
	aSession.setAttribute("username",uname);
	aSession.setAttribute("role",role);
	for (int i = 0; i < news.length; i++) 
	{
		if( news[i].getItemId()==newsID){
			out.println("<html><table><tr><td><h3>" + news[i].getItemTitle() + "</h3></td></tr>");
			out.println("<tr><td>" + news[i].getItemStory() + "</td></tr></table></html>");
			break;
		}
	}
	
	%>
	<form name="story" action="fullstory" method="post">
	  <a href="./index.jsp">Back</a>	
	</form>
</body>
</html>