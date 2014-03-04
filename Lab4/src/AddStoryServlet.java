

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.asupoly.ser422.lab4.dao.INewsDAO;
import edu.asupoly.ser422.lab4.dao.NewsDAOFactory;
import edu.asupoly.ser422.lab4.model.NewsItemBean;
import edu.asupoly.ser422.lab4.model.UserBean;
import edu.asupoly.ser422.lab4.model.UserBean.Role;

/**
 * Servlet implementation class AddStoryServlet
 */
@WebServlet("/AddStoryServlet")
public class AddStoryServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStoryServlet() 
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
		HttpSession aSession = request.getSession();
		String loggedIn = (String) aSession.getAttribute("loggedIn");
		System.out.println("User logged in at addStory page: "+loggedIn);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession aSession = request.getSession();
		String uname = (String) aSession.getAttribute("username");
		String role = (String) aSession.getAttribute("role");
		String loggedIn = (String) aSession.getAttribute("loggedIn");
		
		String storyTitle = request.getParameter("st_title");
		String storyDesc = request.getParameter("st_desc");
		String st_access = request.getParameter("access");
		
		PrintWriter out = response.getWriter();
				
		String repId;
		repId = uname;
		
		NewsItemBean newsItem = new NewsItemBean(storyTitle, storyDesc,repId);
		NewsDAOFactory.getTheDAO().createNewsItem(newsItem);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		//out.println("<html><head><p>"+"This is the AddStory Page"+"</p></head></html>");
		// TODO Auto-generated method stub
	}

}
