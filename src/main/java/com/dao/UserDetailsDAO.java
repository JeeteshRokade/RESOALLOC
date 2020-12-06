package com.dao;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.models.ResourceDetails;
import com.models.UserDetails;
import com.util.HibernateUtil;

public class UserDetailsDAO implements UserDetailsInt {

	@Override
	public UserDetails addUserDetails(String fname, String mname, String lname, String country, String city) {
		// TODO Auto-generated method stub
		
	    UserDetails ud = new UserDetails();
		ud.setFname(fname);
		ud.setMname(mname);
		ud.setLname(lname);
		ud.setCity(city);
		ud.setCountry(country);
		
		return ud;
		
	}
	
	

}
