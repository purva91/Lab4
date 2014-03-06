import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser422.lab4.dao.NewsDAOFactory;
import edu.asupoly.ser422.lab4.dao.NewsDefaultDAO;
import edu.asupoly.ser422.lab4.model.UserBean;
import edu.asupoly.ser422.lab4.model.UserBean.Role;

public class AddUser extends HttpServlet 
{

	private static final long serialVersionUID = 1L;

	// Just prepare static data to display on screen
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{	
		/*
		HttpSession aSession = request.getSession();
		String uname = (String) aSession.getAttribute("username");
		String passwd= (String) aSession.getAttribute("password");
		*/
		//request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{	
		//doGet(request, response);	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role1 = request.getParameter("role");
		PrintWriter out = response.getWriter();
		Role role = null;
		//NewsDAOFactory.getTheDAO().createUser(user);
		String loggedIn = null;
		
		HttpSession aSession = request.getSession();

		aSession.setAttribute("username", username);
		aSession.setAttribute("role", role1);
		
		if (null != username && null != password && !username.isEmpty()	&& !password.isEmpty()) 
		{
			if(role1.equalsIgnoreCase(Role.GUEST.toString()))
			{
				out.println("Invalid Role: Enter Reporter or Subscriber");
				response.sendRedirect(request.getRequestURI());
				return;
			}
			
			else if(role1.equalsIgnoreCase(Role.REPORTER.toString()))
			{
				UserBean nRep = new UserBean(username, password,Role.REPORTER);
				ModelBean.createUser(nRep);
				loggedIn = nRep.getUserId();
				aSession.setAttribute("loggedIn", loggedIn);
				request.getRequestDispatcher("./index.jsp").forward(request, response);	
				System.out.println("Added REPORTER: "+loggedIn);
				return;
				
			}
			
			else if(role1.equalsIgnoreCase(Role.SUBSCRIBER.toString()))
			{
				UserBean nSub = new UserBean(username, password,Role.SUBSCRIBER);
				ModelBean.createUser(nSub);
				loggedIn = nSub.getUserId();
				aSession.setAttribute("loggedIn", loggedIn);
				request.getRequestDispatcher("./index.jsp").forward(request, response);	
				System.out.println("Added SUBSCRIBER: "+loggedIn);
				return;
			}
			else
			{
				out.println("Invalid Role");
				aSession.setAttribute("loggedIn", loggedIn);
				request.getRequestDispatcher("./index.jsp").forward(request, response);	
				return;
			}
		}
	}
}