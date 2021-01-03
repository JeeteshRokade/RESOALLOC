package com.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ResourceRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestid;

	private String requestreason;

	private String status; // New,Pending,Approved

	private String user;

	private String approver;

	@OneToOne(cascade = CascadeType.ALL)
	private Resource resource;

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getRequestreason() {
		return requestreason;
	}

	public void setRequestreason(String requestreason) {
		this.requestreason = requestreason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public String toString() {
		return "ResourceRequest [requestid=" + requestid + ", requestreason=" + requestreason + ", status=" + status
				+ ", user=" + user + ", approver=" + approver + ", resource=" + resource + "]";
	}

}
