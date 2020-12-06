package com.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Resource {

	@Id
	private int resourceid;

	private ResourceDetails resourcedetails;

	@OneToOne
	private User user;

	public int getResourceid() {
		return resourceid;
	}

	public void setResourceid(int resourceid) {
		this.resourceid = resourceid;
	}

	public ResourceDetails getResourcedetails() {
		return resourcedetails;
	}

	public void setResourcedetails(ResourceDetails resourcedetails) {
		this.resourcedetails = resourcedetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Resource [resourceid=" + resourceid + ", resourcedetails=" + resourcedetails + ", user=" + user + "]";
	}

}
