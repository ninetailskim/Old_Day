package WEBCLASS.user.service;
import WEBCLASS.user.dao.UserDao;
import WEBCLASS.user.domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	
	public boolean ajaxvalidateloginname(String loginname)
	{
		try{
		return userDao.ajaxvalidateloginname(loginname);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean login(String loginname,String password)
	{
		try{
		return userDao.login(loginname,password);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean regist(User tempuser)
	{
		try{
		return userDao.regist(tempuser);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean publish(String inputarea,int cid)
	{
		try{
		return userDao.publish(inputarea,cid);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean hwrelease(String loginname,String classId,String hwName)
	{
		System.out.println(loginname + "service");
		try{
		return userDao.hwrelease(loginname,classId,hwName);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
