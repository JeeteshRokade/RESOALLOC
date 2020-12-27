package com.models;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resourceid;

	private ResourceDetails resourcedetails;
    
	
	@OneToOne(cascade = CascadeType.ALL)
    private User useri;

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

	//@OneToOne
	public User getUser() {
		return useri;
	}

	public void setUser(User user) {
		this.useri = useri;
	}

	@Override
	public String toString() {
		return "Resource [resourceid=" + resourceid + ", resourcedetails=" + resourcedetails + ", useri=" + useri + "]";
	}
	
	

}
