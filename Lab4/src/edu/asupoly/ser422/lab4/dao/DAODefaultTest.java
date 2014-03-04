package edu.asupoly.ser422.lab4.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.asupoly.ser422.lab4.model.NewsItemBean;
import edu.asupoly.ser422.lab4.model.UserBean;

public class DAODefaultTest 
{
	//private static final int __SECONDS = 10;
	//private static final String __FILENAME = "dpt.ser";
	
	private static NewsDefaultDAO __dao = null;
	
	private UserBean __userGuest;
	private UserBean __userSubscriber;
	private UserBean __userReporter;
	private UserBean __userReporter2;
	private NewsItemBean __news1;
	private NewsItemBean __news2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//__dao = new NewsPeriodicDAO(__SECONDS, __FILENAME);
		__dao = new NewsDefaultDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		__dao = null;  // forces reclamation of the TimerThread if using NewsPeriodicDAO
	}

	@Before
	public void setUp() throws Exception {
		__userGuest = new UserBean("joe", "joe", UserBean.Role.GUEST);
		__userSubscriber = new UserBean("sue", "sue", UserBean.Role.SUBSCRIBER);
		__userReporter = new UserBean("bob", "bob", UserBean.Role.REPORTER);
		__userReporter2 = new UserBean("dawn", "dawn", UserBean.Role.REPORTER);
		__news1 = new NewsItemBean(1, "news1", "story1", "bob");
		__news2 = new NewsItemBean(2, "news2", "story2", "dawn");
		__dao.createNewsItem(__news1);
		__dao.createNewsItem(__news2);
		__dao.createUser(__userGuest);
		__dao.createUser(__userSubscriber);
		__dao.createUser(__userReporter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetNews() {
		NewsItemBean[] news = __dao.getNews();
		assertTrue(news != null);
		for (int i = 0; i < news.length; i++) {
			assertTrue(news[i] == __news1 || news[i] == __news2);
		}
	}

	@Test
	public void testGetUser() {
		UserBean guest = __dao.getUser(__userGuest.getUserId());
		UserBean subscriber = __dao.getUser(__userSubscriber.getUserId());
		UserBean reporter = __dao.getUser(__userReporter.getUserId());
		
		assertTrue(__userGuest == guest && __userSubscriber == subscriber && __userReporter == reporter);
	}

	@Test
	public void testStoreComment() {
		// boolean storeComment(int newsItemId, String userid, String comment) {
		assertTrue(__dao.storeComment(1, __userSubscriber.getUserId(), "This comment is allowed"));
		assertTrue(__dao.storeComment(1, __userReporter.getUserId(), "This comment allowed too"));
		// These are included to show that the DAO is not responsible for enforcing biz rules here
		assertTrue(__dao.storeComment(1, __userReporter2.getUserId(), "This comment is not allowed"));
		assertTrue(__dao.storeComment(2, __userGuest.getUserId(), "This comment is not allowed either"));
	}

	@Test
	public void testGetNewsItem() {
		NewsItemBean news1 = __dao.getNewsItem(1);
		NewsItemBean news2 = __dao.getNewsItem(2);
		
		assertTrue(__news1 == news1 && __news2 == news2);
	}

	@Test
	public void testUpdateNewsItem() {
		assertTrue(__dao.updateNewsItem(1, "newTitle1", "newStory1"));
		// __news1 should have been updated, shows shallow copy
		assertTrue(__news1.getItemTitle().equals("newTitle1") && __news1.getItemStory().equals("newStory1"));
	}
}
