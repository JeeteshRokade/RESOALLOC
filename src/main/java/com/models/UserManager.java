package com.models;

import javax.persistence.*;

@Entity
public class UserManager {

	@Id
	private String UserId;

	private String ManagerId;
	
	private String password;


	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getManagerId() {
		return ManagerId;
	}

	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserManager [ UserId=" + UserId + ", ManagerId=" + ManagerId + ", password=" + password
				+ "]";
	}
	
	



}
