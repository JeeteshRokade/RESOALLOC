package com.dao;

import com.models.ResourceDetails;
import com.models.UserDetails;

public class ResourceDetailDAO implements ResourceDetailsInt {

	@Override
	public ResourceDetails addUserDetails(String resourcetype, String resourcename) {

		ResourceDetails rd = new ResourceDetails();
		rd.setResourcename(resourcename);
		rd.setResourcetype(resourcetype);

		return rd;
	}

}
