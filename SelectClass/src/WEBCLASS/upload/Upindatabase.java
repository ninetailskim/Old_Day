package WEBCLASS.upload;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Upindatabase {
	
	public boolean upsetdatabase(UpResc upresc) throws Exception
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
					String sql = "select * from UserInfo where userName='" + upresc.getUperId() + "'";
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					int userId = rs.getInt("userId");
					sql = "select * from UprReco where hwId=" + upresc.getHwId();  
					rs = st.executeQuery(sql);
					if(rs.next())
					{
						rs.updateString("pathName", upresc.getPathName()); // 更新字段
						rs.updateRow(); 
					}
					else
					{
					sql = "select * from UprReco";
					rs.moveToInsertRow();
					rs.updateInt("uperId", userId);
					rs.updateString("hwId", upresc.getHwId());
					rs.updateString("pathName", upresc.getPathName());
					rs.insertRow();
					}
					conn.close();
					return true;	
	}
	
	public UpResc upoutdatabase(String hwId) throws Exception
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
					System.out.println(hwId + "abcdefghijklmn");
					String sql = "select * from HomeWork where hwId=" + hwId;
					System.out.println(sql);
					ResultSet rs = st.executeQuery(sql);
					rs.next();
					int hwTid = rs.getInt("hwTid");
					System.out.println(hwTid + "----------------------------");
					sql = "select * from UprReco where hwId=" + hwId + " and uperId=" + hwTid;
					System.out.println(sql);
					rs = st.executeQuery(sql);
					UpResc upresc = new UpResc();
					if(rs.next()){
					upresc.setPathName(rs.getString("pathName"));
					upresc.setUperId(rs.getString("UperId"));
					upresc.setHwId(rs.getString("HwId"));
					System.out.println(upresc.getPathName() + "````````````````````````````````````");
					}
					else
						upresc.setPathName("No File");
					conn.close();
					return upresc;	
	}
}
