package com.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;


@Entity
public class User {
	
	
    @Id
	private String userid;
	
    @Column
	private UserDetails ud;
	
    @Column
	private String role;
    
    @OneToOne(mappedBy = "useri",fetch = FetchType.EAGER)
    @NotFound
    private Resource res;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public UserDetails getUd() {
		return ud;
	}

	public void setUd(UserDetails ud) {
		this.ud = ud;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Resource getRes() {
		return res;
	}

	public void setRes(Resource res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", ud=" + ud + ", role=" + role + ", res=" + res + "]";
	}
	
	
	
	
	
}
