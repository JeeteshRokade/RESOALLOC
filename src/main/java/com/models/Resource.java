package com.models;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Resource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resourceid;

	@Column
	private ResourceDetails resourcedetails;

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

	@Override
	public String toString() {
		return "Resource [resourceid=" + resourceid + ", resourcedetails=" + resourcedetails + "]";
	}



}
