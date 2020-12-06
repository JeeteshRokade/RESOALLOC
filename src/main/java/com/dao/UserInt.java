package com.dao;

import java.util.List;

import com.models.Resource;
import com.models.UserDetails;
import com.models.User;

public interface UserInt {
	
	public abstract User getUserbyId(int userid);
	public abstract List<User> getAllUsers();
	public abstract void addUser(UserDetails ud,String role,Resource resource);
	//public abstract void updateUser(int userid);
	public abstract void deleteUser(int userid);


}
