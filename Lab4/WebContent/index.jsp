<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="edu.asupoly.ser422.lab4.model.*"%>
<%@page import="edu.asupoly.ser422.lab4.dao.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="user" action="index" method="post">
<%
	HttpSession aSession = request.getSession();
	String uname = (String) aSession.getAttribute("username");
	String role = (String) aSession.getAttribute("role");
	String loggedIn = (String) aSession.getAttribute("loggedIn");
%>
	<h2>NEW News</h2>
<%
	if(loggedIn!=null)
	{
		out.println("<p> Welcome user "+uname+ " with role "+role+" </p>");
		if(role.equalsIgnoreCase("Reporter"))
		{
			out.println("<td><a href= "+ "./addStory.jsp"+">Create New Story</a></td>");
		}
	}
	NewsItemBean[] news = NewsDAOFactory.getTheDAO().getNews();
	aSession.setAttribute("newsList",news);
	
	//HttpSession aSession = request.getSession();
	for (int i = 0; i < news.length; i++) 
	{
		aSession.setAttribute("ItemId",i);
		out.println("<td><a href= " + " ./viewfullstory.jsp>"+ news[i].getItemTitle()+"</a></td>");
	}
	
%>

	<p>NEW news is a news resource about NEW stuff.</p>
	
	
	<br/>
	<table border="0">
		<tr>
			<td><a href="./about.html">About</a></td>
			<%
				if(loggedIn==null)
					out.println("<td><a href="+ "./login.jsp"+">Login</a></td>");
				else
				{
					loggedIn = null;
					aSession.setAttribute("loggedIn", loggedIn);
					out.println("<td><a href="+ "index"+">Logout</a></td>");					 
				}	
				
			%>
			</tr>
	</table>
</form>
</body>
</html>