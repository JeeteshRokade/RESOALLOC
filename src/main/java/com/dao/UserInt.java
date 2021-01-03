package com.dao;

import java.util.List;

import com.models.Resource;
import com.models.UserDetails;
import com.models.User;

public interface UserInt {

	public abstract User getUserbyId(String userid);

	public abstract List<User> getAllUsers();

	public abstract User addUser(String userid, UserDetails ud, String role, Resource resource);

	// public abstract void updateUser(int userid);
	public abstract void deleteUser(String userid);
	
	public abstract void updateResource(String userid , int resourceid);

}
