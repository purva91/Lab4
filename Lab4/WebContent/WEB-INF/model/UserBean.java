package edu.asupoly.ser422.lab4.model;

public class UserBean 
{
	public enum Role 
	{
	    GUEST, SUBSCRIBER, REPORTER;
	    
	    public String toString() 
	    {
	    		switch(this) 
	    		{
	    			case GUEST: return "Guest";
	    			case SUBSCRIBER: return "Subscriber";
	    			case REPORTER: return "Reporter";
	    			default: throw new IllegalArgumentException();
	    		}
	    }
	}
	
	private String userId;
	private String passwd;
	private Role role;
	
	public UserBean(String id, String passwd, Role r) 
	{
		this.userId = id;
		this.passwd = passwd;
		this.role = r;
	}
	protected UserBean(UserBean user, Role newRole) 
	{
		this.userId = user.userId;
		this.passwd = user.passwd;
		this.role = newRole;
	}
	
	public String getUserId() 
	{
		return userId;
	}

	public String getPasswd() 
	{
		return passwd;
	}
	
	public Role getRole() 
	{
		return role;
	}
	
	public String toString() 
	{
		return "User " + userId + " of Role " + role.toString();
	}
}

