package commonsql.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commonsql.bean.CatGameUser;
import commonsql.bean.GameProcessing;
import commonsql.util.BaseConnection;

public class GameProcessingDao {

	/**
	 * @param args
	 */
	public ArrayList<GameProcessing> getList(){
		ArrayList<GameProcessing> gameProcesses = new ArrayList<GameProcessing>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from game_processing";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				GameProcessing gameProcess = new GameProcessing();
				
				gameProcess.setGameId(rs.getInt("gameId"));
				gameProcess.setCatUserId(rs.getInt("catUserId"));
				gameProcess.setCatSlaveUserId(rs.getInt("catSlaveUserId"));
				
				gameProcess.setCreateTime(rs.getDate("createTime"));
				gameProcess.setEndTime( rs.getDate("endTime"));

				gameProcesses.add(gameProcess);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		return gameProcesses;
		
		
	}
	public boolean insert(GameProcessing gameProcess){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into game_processing (gameId ,catUserId,catSlaveUserId,createTime,endTime) values (?,?,?,?,?) ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gameProcess.getGameId());
			ps.setInt(2, gameProcess.getCatUserId());
			ps.setInt(3, gameProcess.getCatSlaveUserId());
			ps.setDate(4, (Date) gameProcess.getCreateTime());
			ps.setDate(5, (Date) gameProcess.getEndTime());
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
		
		GameProcessing gameProcess = new GameProcessing();

//		gameProcess.setGameId(123);
		gameProcess.setCatUserId(12346);
		gameProcess.setCatSlaveUserId(159);
		
		gameProcess.setCreateTime(date);
		gameProcess.setEndTime(date);
		GameProcessingDao gameProcessD = new GameProcessingDao();
		gameProcessD.insert(gameProcess);
		
		
	}

}
