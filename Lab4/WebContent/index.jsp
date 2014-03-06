<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="edu.asupoly.ser422.lab4.model.*"%>
<%@page import="edu.asupoly.ser422.lab4.dao.*"%>
<%@page import="edu.asupoly.ser422.lab4.model.ModelBean"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="user" action="index" method="get">
<%
	HttpSession aSession = request.getSession(false);
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
			out.println("<table><tr><td><a href= "+ "./addStory.jsp"+">Create New Story</a></td></tr></table>");
		}
	}
	NewsItemBean[] news = ModelBean.getNews();
	aSession.setAttribute("newsList",news);
	aSession.setAttribute("loggedIn",loggedIn);
	aSession.setAttribute("username",uname);
	aSession.setAttribute("role",role);
	//HttpSession aSession = request.getSession();
	out.println("<table>");
	for (int i = 0; i < news.length; i++) 
	{
		//aSession.setAttribute("ItemId",i);
		out.println("<tr><td><a href= " + " ./viewfullstory.jsp?newsID="+ news[i].getItemId()+">"+ news[i].getItemTitle()+"</a></td></tr>");
		out.println("<tr><td>Session id "+aSession.getId()+"</tr></td>");
	}
	out.println("</table>");
	
%>

	<p>NEW news is a news resource about NEW stuff.</p>
	
	
	<br/>
	<table border="0">
		<tr>
			<td><a href="./about.html">About</a></td>
			<%
				if(loggedIn==null){
					out.println("<td><a href="+ "./login.jsp"+">Login</a></td>");
					out.println("Login is null!");
				}else
				{
					aSession.setAttribute("loggedIn", null);
					/* aSession.setAttribute("username", null);
					aSession.setAttribute("role", null);
					aSession.setAttribute("password", null); */
					out.println("<td><a href="+ "index"+">Logout</a></td>");					 
				}	
				
			%>
			</tr>
	</table>
</form>
</body>
</html>