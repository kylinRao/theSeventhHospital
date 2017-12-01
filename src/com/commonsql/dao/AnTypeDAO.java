package commonsql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commonsql.bean.AnType;
import commonsql.util.BaseConnection;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年7月23日 下午1:35:43 
* 类说明 
*/
public class AnTypeDAO {
	public ArrayList<AnType> getList(){
		ArrayList<AnType> ar = new ArrayList<AnType>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from antype";
		
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AnType an = new AnType();
				an.setAnId(rs.getInt("anid"));
				an.setAnName(rs.getString("anname"));
				ar.add(an);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseConnection.closeRes(conn, ps, rs);
		}
		return ar;
		
	}

}
