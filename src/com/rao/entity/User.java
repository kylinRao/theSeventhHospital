package com.rao.entity;

public class User extends idEntity {
	private String userName;
	private String passWord;
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + userName + ", passWord=" + passWord + ", email=" + email + ", id=" + id + "]";
	}

}
