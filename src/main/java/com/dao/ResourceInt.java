package com.dao;

import java.util.List;

import com.models.Resource;
import com.models.User;
import com.models.ResourceDetails;

public interface ResourceInt {

	public abstract Resource getResourcebyId(int resourceid);

	public abstract List<Resource> getAllUsers();

	public abstract void addResource(ResourceDetails rd, User user);

	// public abstract void updateUser(int userid);
	public abstract void deleteUser(int resourceid);

}
