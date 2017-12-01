package commonsql.bean;

import java.util.Date;

public class GameProcessing {
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getCatUserId() {
		return catUserId;
	}
	public void setCatUserId(int catUserId) {
		this.catUserId = catUserId;
	}
	public int getCatSlaveUserId() {
		return catSlaveUserId;
	}
	public void setCatSlaveUserId(int catSlaveUserId) {
		this.catSlaveUserId = catSlaveUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	private int gameId;
	private int catUserId;
	private int catSlaveUserId;

	private Date createTime;
	private Date endTime;

}
