package com.appsdevlopersblog.app.ws.userservice;

import com.appsdevlopersblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdevlopersblog.app.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);
}
