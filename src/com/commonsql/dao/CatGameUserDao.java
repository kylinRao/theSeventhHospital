package commonsql.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import commonsql.bean.CatGameUser;
import commonsql.util.BaseConnection;

public class CatGameUserDao {
	
	public ArrayList<CatGameUser> getList(){
		ArrayList<CatGameUser> catGameUsers = new ArrayList<CatGameUser>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from cat_game_user";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CatGameUser user = new CatGameUser();
				user.setCatUserId(rs.getInt("catUserId"));
				user.setTelephone(rs.getString("telephone"));
				user.setIMEI(rs.getString("IMEI"));
				user.setCreateTime(rs.getDate("createTime"));

				catGameUsers.add(user);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return catGameUsers;
		
		
	}
	
	public ArrayList<CatGameUser> getListByIMEI( String IMEI){
		ArrayList<CatGameUser> catGameUsers = new ArrayList<CatGameUser>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = String.format("select * from cat_game_user where  IMEI = '%s'",IMEI);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CatGameUser user = new CatGameUser();
				user.setCatUserId(rs.getInt("catUserId"));
				user.setTelephone(rs.getString("telephone"));
				user.setIMEI(rs.getString("IMEI"));
				user.setCreateTime(rs.getDate("createTime"));

				catGameUsers.add(user);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return catGameUsers;
		
		
	}
	
	
	
	
	public boolean insert(CatGameUser user){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into cat_game_user (catUserId ,telephone,IMEI,createTime) values (?,?,?,?) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getCatUserId());
			ps.setString(2, user.getTelephone());
			ps.setString(3, user.getIMEI());
			ps.setDate(4, (Date) user.getCreateTime());
			int a = ps.executeUpdate();
			if (a > 0){
				b = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps,null);
		}
		
		return b;
	}
	
	
	public static void main(String[] args) {
		Date date=new Date(System.currentTimeMillis());
		System.out.println(date);
		
		CatGameUser user = new CatGameUser();
//		user.setCatUserId(null);
		user.setTelephone("18941133470");
		user.setIMEI("ASDFASDFASDF18941133470");
		
		user.setCreateTime(date);
		CatGameUserDao catUser = new CatGameUserDao();
		catUser.insert(user);
		
		
	}

}
