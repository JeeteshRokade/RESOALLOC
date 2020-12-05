package com.models;

import javax.persistence.Embeddable;

@Embeddable
public class ResourceDetails {
	
	private String resourcetype;
	
	private String resourcename;

	public String getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(String resourcetype) {
		this.resourcetype = resourcetype;
	}

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	@Override
	public String toString() {
		return "ResourceDetails [resourcetype=" + resourcetype + ", resourcename=" + resourcename + "]";
	}
	
	
	
	

}
