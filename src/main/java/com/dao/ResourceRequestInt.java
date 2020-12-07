package com.dao;

import java.util.List;

import com.models.Resource;
import com.models.ResourceRequest;
import com.models.User;
import com.models.UserDetails;

public interface ResourceRequestInt {

	public abstract ResourceRequest getRequesbyId(int requestid);

	public abstract List<ResourceRequest> getRequestbyUser(int userid);

	public abstract List<ResourceRequest> getRequestbyApprover(int approverid);

	public abstract List<ResourceRequest> getAllRequests();

	public abstract void addRequest(String reason, String status, User user, User approver, Resource resource);

	// public abstract void updateUser(int userid);
	public abstract void deleteRequest(int requestid);

}
