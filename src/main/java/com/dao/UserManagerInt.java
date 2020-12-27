package com.dao;

import com.models.UserManager;

public interface UserManagerInt {
	public abstract UserManager addUserManager(String userid, String managerid, String password);
	public abstract boolean getuserpass(String userid,String pass);
	public abstract String getManagerId(String userid);

}
