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
	HttpSession aSession = request.getSession();
	String nTitle = (String) aSession.getAttribute("nTitle");
	out.println("<html>" + nTitle + "</html>");
	
	NewsItemBean[] news = (NewsItemBean[]) aSession.getAttribute("newsList");
	int itemId = (Integer) aSession.getAttribute("ItemId");
	for (int i = 0; i < news.length; i++) 
	{
		if(i == itemId)
			out.println("<html>" + news[i].getItemStory() + "</html>");
	}
	%>
	<form name="story" action="fullstory" method="post">
		
	</form>
</body>
</html>