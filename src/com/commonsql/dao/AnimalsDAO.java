package commonsql.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commonsql.bean.Animals;
import commonsql.util.BaseConnection;

import java.sql.PreparedStatement;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年7月23日 下午1:18:30 
* 类说明 
*/
public class AnimalsDAO {
	public ArrayList<Animals> getList(){
		ArrayList<Animals> ar = new ArrayList<Animals>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from Animals";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Animals an = new Animals();
				an.setId(rs.getInt("id"));
				an.setName(rs.getString("name"));
				an.setAge(rs.getInt("age"));
				an.setAnId(rs.getInt("anid"));
				ar.add(an);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return ar;
		
		
	}
	public boolean insert(Animals an){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into Animals (name ,age,anid) values (?,?,?) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, an.getName());
			ps.setInt(2, an.getAge());
			ps.setInt(3, an.getAnId());
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
		Animals an = new Animals();
		an.setName("金丝胖");
		an.setAnId(1);
		an.setAge(100);
		AnimalsDAO ad = new AnimalsDAO();
		ad.insert(an);
		
		
	}

}
