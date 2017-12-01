package commonsql.bean;

import java.util.Date;

public class CatGameUser {
	
	private int catUserId;
	private String telephone;
	private String IMEI;
	private Date createTime;
	
	
	public int getCatUserId() {
		return catUserId;
	}
	public void setCatUserId(int catUserId) {
		this.catUserId = catUserId;
	}




	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	

}
