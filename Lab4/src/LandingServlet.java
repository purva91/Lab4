import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser422.lab4.dao.NewsDAOFactory;
import edu.asupoly.ser422.lab4.model.NewsItemBean;
import edu.asupoly.ser422.lab4.model.UserBean;
import edu.asupoly.ser422.lab4.model.UserBean.Role;
import edu.asupoly.ser422.lab4.dao.NewsDefaultDAO;
import edu.asupoly.ser422.lab4.dao.DAODefaultTest;
import edu.asupoly.ser422.lab4.model.NewsItemBean.*;


/**
 * Servlet implementation class LandingServlet
 */
public class LandingServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LandingServlet() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

		System.out.println("Came to Landing Page");
		HttpSession aSession = request.getSession(true);
		String loggedIn = (String) aSession.getAttribute("loggedIn");
		String role = (String) aSession.getAttribute("role");
		String uname = (String) aSession.getAttribute("username");

		if((!(role.equalsIgnoreCase("Subscriber")||role.equalsIgnoreCase("Reporter")))||(role==null)){
			role="Guest";
			aSession.setAttribute("role", role);
			aSession.setAttribute("loggedIn",null);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);

	/*	if((loggedIn==null)||(!(request.isRequestedSessionIdValid())))
			aSession.invalidate();*/



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub		
		doGet(request,response);		

	}

}
