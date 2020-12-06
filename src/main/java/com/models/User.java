package com.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private UserDetails ud;

	private String role;

	@OneToOne
	private Resource resource; // test if it can be null

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserDetails getUd() {
		return ud;
	}

	public void setUd(UserDetails ud) {
		this.ud = ud;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ud=" + ud + ", role=" + role + ", resource=" + resource + "]";
	}

}
