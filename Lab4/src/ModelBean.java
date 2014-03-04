import edu.asupoly.ser422.lab4.dao.NewsDAOFactory;
import edu.asupoly.ser422.lab4.dao.NewsDefaultDAO;
import edu.asupoly.ser422.lab4.model.NewsItemBean;
import edu.asupoly.ser422.lab4.model.UserBean;
import edu.asupoly.ser422.lab4.model.UserBean.Role;

public class ModelBean 
{
	ModelBean()
	{
		NewsItemBean[] news = NewsDAOFactory.getTheDAO().getNews();
		
	}
	

}
