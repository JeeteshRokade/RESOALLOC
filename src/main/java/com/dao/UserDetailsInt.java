package com.dao;

import com.models.UserDetails;

public interface UserDetailsInt {

	public abstract UserDetails addUserDetails(String fname, String mname, String lname, String country, String city);

}
