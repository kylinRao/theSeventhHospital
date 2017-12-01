package commonsql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import commonsql.bean.Animals;

import java.sql.PreparedStatement;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年7月22日 下午10:56:30 
* 类说明 
*/
public class BaseConnection {
	
	
	public static Connection getConnection(){
		
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/CatGameServer?useUnicode=true&characterEncoding=UTF-8","root","Huawei123");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeRes(Connection conn , PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
				
			}
			
			if(ps!=null){
				ps.close();
				
			}
			if (conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	


}
