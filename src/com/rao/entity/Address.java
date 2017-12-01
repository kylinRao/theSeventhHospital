package com.rao.entity;

public class Address extends idEntity {
	private String city;

	private String country;
	private String userId;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCouty() {
		return country;
	}

	public void setCouty(String couty) {
		this.country = couty;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Address [city=" + city + ", couty=" + country + ", userId=" + userId + ", id=" + id + "]";
	}

}
