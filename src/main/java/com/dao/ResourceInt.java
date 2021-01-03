package com.dao;

import java.util.List;

import com.models.Resource;
import com.models.User;
import com.models.ResourceDetails;

public interface ResourceInt {

	public abstract Resource getResourcebyId(int resourceid);

	public abstract List<Resource> getAllResources();

	public abstract Resource addResource(ResourceDetails rd);

	// public abstract void updateUser(int userid);
	public abstract void deleteResource(int resourceid);
	
}
