package MySqlBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.message.resp.Music;

public class LinkDB {
	
	public static final String url = "jdbc:mysql://115.159.49.154/wx";
	
	public static final String name = "com.mysql.jdbc.Driver";
	
	public static final String user = "root";
	
	public static final String password = "123456";
	
	public static String register(String str){		
		String resultBack = "";
		try{
			Class.forName(name);
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from user where Open_id = '" + str + "'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				resultBack = "你已经注册过了，请勿重复注册！";
			}else{
				sql = "insert user(Open_id,Score) values('" + str +"',0);";
				int rs1 = st.executeUpdate(sql);
				if(rs1 == 1){
					resultBack = "注册成功，积分为0.";
				}else{
					resultBack = "系统出错，请稍后重试";
				}
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultBack;
	}	
	public static int QueryScore(String str){		
		int resultBack = 0;
		try{
			Class.forName(name);
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from user where Open_id = '" + str + "'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				resultBack = rs.getInt(2);
			}else{
				resultBack = -1;
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultBack;
	}
	public static int AddScore(String str){
		int resultBack = 0;
		try{
			Class.forName(name);
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from user where Open_id = '" + str + "'";
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				int nowScore = Integer.parseInt(rs.getString("Score")) + 5;
				sql = "update user set Score = '" + nowScore + "' where Open_id = '" + str + "'";
				int change = st.executeUpdate(sql);
				if(change >= 0)
					resultBack = nowScore;
				else
					resultBack = -1;
			}else{
				resultBack = -1;
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultBack;
	}
	public static Music GetMusic(){
		Music music = new Music();
		try{
			Class.forName(name);
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "select * from music";
			ResultSet rs = st.executeQuery(sql);
			rs.last();
			int rowCount = rs.getRow();
			rs.beforeFirst();
			int ranNum = (int)(1 + Math.random() * rowCount);
			for(int i = 1;i < ranNum;i ++){
				rs.next();
			}
			if(rs.next()){
				music.setTitle(rs.getString("Name"));
				music.setDescription(rs.getString("Description"));
				music.setMusicUrl(rs.getString("Url"));
				music.setHQMusicUrl(rs.getString("HQUrl"));
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return music;
	}
	
	
}
