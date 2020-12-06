package com.models;

import javax.persistence.Embeddable;

@Embeddable
public class UserDetails {

	private String fname;
	private String mname;
	private String lname;
	private String country;
	private String city;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UserDetails [fname=" + fname + ", mname=" + mname + ", lname=" + lname + ", country=" + country
				+ ", city=" + city + "]";
	}

}
