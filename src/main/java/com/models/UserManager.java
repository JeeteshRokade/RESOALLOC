package com.models;

import javax.persistence.*;

@Entity
public class UserManager {
	
	@Id
	private int Id;
	
	private int UserId;
	
	private int ManagerId;
	
	public int getId() {
		return Id;
	}
	public int getUserId() {
		return UserId;
	}
	public int getManagerId() {
		return ManagerId;
	}
	
	

}
