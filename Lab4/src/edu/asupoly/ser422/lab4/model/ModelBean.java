package edu.asupoly.ser422.lab4.model;
import edu.asupoly.ser422.lab4.dao.NewsDAOFactory;
import edu.asupoly.ser422.lab4.dao.NewsDefaultDAO;
import edu.asupoly.ser422.lab4.model.NewsItemBean;
import edu.asupoly.ser422.lab4.model.UserBean;
import edu.asupoly.ser422.lab4.model.UserBean.Role;

public class ModelBean 
{	
	public static NewsItemBean[] getNews()
	{
		NewsItemBean[] news = NewsDAOFactory.getTheDAO().getNews();
		return news;		
	}
	
	public static boolean createUser(UserBean user) 
	{
		 return NewsDAOFactory.getTheDAO().createUser(user);
	}
	
	public static UserBean getUser(String userid)
	{
		return NewsDAOFactory.getTheDAO().getUser(userid);
	}
	
	public boolean storeComment(int newsItemId, String userid, String comment)
	{
		return NewsDAOFactory.getTheDAO().storeComment(newsItemId, userid, comment);
		
	}
	
	public static boolean createNewsItem(NewsItemBean nib)
	{
		return NewsDAOFactory.getTheDAO().createNewsItem(nib);
	}
	
	public NewsItemBean getNewsItem(int i)
	{
		return NewsDAOFactory.getTheDAO().getNewsItem(i);
	}
	
	public boolean updateNewsItem(int newsItemId, String newTitle, String newStory)
	{
		return NewsDAOFactory.getTheDAO().updateNewsItem(newsItemId, newTitle, newStory);
	}
	
	public boolean deleteNewsItem(int newsItemId)
	{
		return NewsDAOFactory.getTheDAO().deleteNewsItem(newsItemId);
	}

}
