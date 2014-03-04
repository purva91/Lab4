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
		String[] news_title={"News1","News2","News3"};
		String[] news_story={"This is News1","This is News2","This is News3"};
		NewsItemBean news1 = new NewsItemBean("News1", "This is News1","Public");
		NewsItemBean news2 = new NewsItemBean("News2", "This is News2","Public");
		NewsItemBean news3 = new NewsItemBean("News3", "This is News3","Public");
		int flag=0;
		NewsItemBean[] news = NewsDAOFactory.getTheDAO().getNews();
		for (int i = 0; i < news.length; i++) 
		{
			if((news_title[i].contains(news1.getItemTitle()))||(news_title[i].contains(news2.getItemTitle()))||(news_title[i].contains(news3.getItemTitle())))
			{
				flag=1;
			}
			else
			{
				flag = 0;				
			}
				
		}
		
		if(flag==0)
		{
			NewsDAOFactory.getTheDAO().createNewsItem(news1);
			NewsDAOFactory.getTheDAO().createNewsItem(news2);
			NewsDAOFactory.getTheDAO().createNewsItem(news3);
		}
		
		HttpSession aSession = request.getSession(false);
		String loggedIn = (String) aSession.getAttribute("loggedIn");
		
		String role;
		role="Guest";
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		aSession.setAttribute("role", role);
		if((loggedIn==null)||(!(request.isRequestedSessionIdValid())))
			aSession.invalidate();
				
		
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
