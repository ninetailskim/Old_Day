package WEBCLASS.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import WEBCLASS.user.domain.User;

public class UserDao {
	//依赖数据库，坑爹的他用的什么狗屁TxQueryRunner();
	
	public boolean ajaxvalidateloginname(String loginname) throws Exception
	{
		
			// 1.注册驱动程序类
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// 2.设置连接URL、用户名和密码，建立数据库连接
			String url = "jdbc:jtds:sqlserver://localhost:1433/WebClass";
			Connection conn = DriverManager.getConnection(url, "sa", "yugioh0329");

			// 3-创建可更新数据集
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 4-执行SQL查询，返回数据集(参数是int类型)
			System.out.println(loginname + "UserDao");
			String sql = "select * from UserInfo where userName = '" + loginname + "'"; 
			ResultSet rs = st.executeQuery(sql);
			
			int flag;
			// 如果存在下一行更新
			if (rs.next()) {
				System.out.println("userName ="+rs.getString("userName"));
				flag = 1;// 更新行
			}
			else
				flag = 0;
			// 5-关闭数据库连接
			conn.close();
			if(flag == 1)
				return false;
			else
				return true;		
	}
	public boolean login(String loginname,String password) throws Exception
	{
		
			// 1.注册驱动程序类
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// 2.设置连接URL、用户名和密码，建立数据库连接
			String url = "jdbc:jtds:sqlserver://localhost:1433/WebClass";
			Connection conn = DriverManager.getConnection(url, "sa", "yugioh0329");

			// 3-创建可更新数据集
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 4-执行SQL查询，返回数据集(参数是int类型)
			System.out.println(loginname + "UserDao");
			System.out.println(password + "UserDao");
			String sql = "select * from UserInfo where userName = '" + loginname + "'"; 
			ResultSet rs = st.executeQuery(sql);
			
			int flag;
			// 如果存在下一行更新
			if (rs.next()) {
				System.out.println(rs.getString("userPsaaword") + "DB");
				if(rs.getString("userPsaaword").equals(password))
					flag = 0;
				else
					flag = 1;// 更新行
			}
			else
				flag = 1;
			// 5-关闭数据库连接
			conn.close();
			if(flag == 1)
				return false;
			else
				return true;		
	}
	
	public boolean regist(User tempuser) throws Exception
	{
		
			// 1.注册驱动程序类
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// 2.设置连接URL、用户名和密码，建立数据库连接
			String url = "jdbc:jtds:sqlserver://localhost:1433/WebClass";
			Connection conn = DriverManager.getConnection(url, "sa", "yugioh0329");

			// 3-创建可更新数据集
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 4-执行SQL查询，返回数据集(参数是int类型)
			String sql = "select * from UserInfo"; 
			ResultSet rs = st.executeQuery(sql);
			
			rs.moveToInsertRow();
			rs.updateString("userName", tempuser.getUserName());
			rs.updateString("userPsaaword", tempuser.getUserPassword());
			rs.updateString("userEmail", tempuser.getEmail());
			rs.updateInt("userIdent",tempuser.getUserIdent());
			rs.insertRow();
			conn.close();
			return true;		
	}
	
	public boolean publish(String inputarea,int cid) throws Exception
	{
		
			// 1.注册驱动程序类
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// 2.设置连接URL、用户名和密码，建立数据库连接
			String url = "jdbc:jtds:sqlserver://localhost:1433/WebClass";
			Connection conn = DriverManager.getConnection(url, "sa", "yugioh0329");

			// 3-创建可更新数据集
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 4-执行SQL查询，返回数据集(参数是int类型)
			String sql = "select * from ClassInfo where classId = " + cid; 
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				rs.updateString("classPublish", inputarea); // 更新字段
				rs.updateRow(); 
			}
			conn.close();
			return true;		
	}
	
	public boolean hwrelease(String loginname,String classId,String hwName) throws Exception
	{
			System.out.println(loginname + "Dao");
			// 1.注册驱动程序类
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// 2.设置连接URL、用户名和密码，建立数据库连接
			String url = "jdbc:jtds:sqlserver://localhost:1433/WebClass";
			Connection conn = DriverManager.getConnection(url, "sa", "yugioh0329");

			// 3-创建可更新数据集
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			// 4-执行SQL查询，返回数据集(参数是int类型)
			String sql = "select * from UserInfo where userName = '" + loginname +"'"; 
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			String hwTid = rs.getString("userId");
			sql = "select * from HomeWork";
			rs = st.executeQuery(sql);
			rs.moveToInsertRow();
			rs.updateString("hwName",hwName);
			rs.updateString("hwTid", hwTid);
			rs.updateInt("hwCid",Integer.parseInt(classId));
			rs.insertRow();
			conn.close();
			return true;		
	}
}
