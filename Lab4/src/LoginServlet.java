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
import edu.asupoly.ser422.lab4.model.UserBean;
import edu.asupoly.ser422.lab4.model.UserBean.Role;
import edu.asupoly.ser422.lab4.dao.NewsDefaultDAO;
import edu.asupoly.ser422.lab4.dao.DAODefaultTest;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		// Put the user list in request and let freemarker paint it.
		//request.setAttribute("users", userList);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println(userList.get(1).getUserId());
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String msg = null;
		String role=null;
		PrintWriter out = response.getWriter();
		HttpSession aSession = request.getSession();
		String loggedIn = null;
		
		aSession.setAttribute("username", username);
		aSession.setAttribute("password", password);
		//aSession.setAttribute("loggedIn", loggedIn);
			
				
		if (username == null || username.length() == 0 || password == null || password.length() == 0) 
		{
			msg = "The username or password cannot be empty";
			out.println("<html>" + msg + "</html>");
			response.sendRedirect(request.getRequestURI());
			return;
		}

		else if (!username.equals(password)) 
		{
			msg = "The username or password is not valid";
			out.println("<html>" + msg + "</html>");
			response.sendRedirect(request.getRequestURI());
			return;
		}
		// HERE YOU HAVE TO CHECK IF THE USER EXISTS OR NOT!
		else 
		{
			UserBean user = ModelBean.getUser(username);
			if(user!=null)
					role = user.getRole().toString();
			
			//System.out.println("Role "+role);
			if((user == null)||(role.equalsIgnoreCase("Guest")))
			{
				//doesn't exist
				System.out.println("New user");
				//out.println("New user");
				//response.sendRedirect("./register.jsp");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			
			else if(role.equalsIgnoreCase("Subscriber"))
			{
				aSession.setAttribute("role", role);
				loggedIn = user.getUserId();
				aSession.setAttribute("loggedIn", loggedIn);
				request.getRequestDispatcher("./index.jsp").forward(request, response);
				System.out.println("Going to Landing Page as subscriber");
				return;
			}
			else
			{
				//for reporter
				aSession.setAttribute("role", role);
				loggedIn = user.getUserId();
				aSession.setAttribute("loggedIn", loggedIn);
				request.getRequestDispatcher("./index.jsp").forward(request, response);				
				System.out.println("Going to Landing Page as reporter");
				return;
			}
					
		}	
		//System.out.println(msg);
		//doGet(request, response);
		
	}

}
