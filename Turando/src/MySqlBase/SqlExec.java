package MySqlBase;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlExec {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;
	
	public static String Register(String str){
		
		sql = "select * from user where Open_id = '" + str + "'";
		db1 = new DBHelper(sql);
		try{
			ret = db1.pst.executeQuery();
			if(ret.next()){
				return "该微信号已经注册，请勿重复注册！";
			}else{
				//sql = "insert user(Open_id,Score) values('" + str +"',0);";
				//db1 = new DBHelper(sql);
				//ret = db1.pst.executeQuery();
				return "注册成功！会员积分为 0";
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return "服务出错，请稍后重试！";
	}
}