package com.appsdevlopersblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdevlopersblog.app.ws.shared.Utils;
import com.appsdevlopersblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevlopersblog.app.ws.ui.model.response.UserRest;
import com.appsdevlopersblog.app.ws.userservice.UserService;


@Service
class UserServiceImpl implements UserService {

	Map<String, UserRest> users;
	
	Utils utils;
	
	public UserServiceImpl(){
		
	}
	
	@Autowired
	public UserServiceImpl(Utils utils){
		this.utils = utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();

		returnValue.setFirstname(userDetails.getFirstname());
		returnValue.setLastname(userDetails.getLastname());
		returnValue.setEmail(userDetails.getEmail());

		String userId = utils.getUserId();

		returnValue.setUserid(userId);

		if (users == null)
			users = new HashMap<>();
		users.put(userId, returnValue);
		return returnValue;
	}

}
