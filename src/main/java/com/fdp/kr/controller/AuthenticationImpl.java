package com.fdp.kr.controller;

import com.fdp.kr.data.DataSingleton;
import com.fdp.kr.datamodel.User;
import com.fdp.kr.request.RegisterUserRequest;

public class AuthenticationImpl implements Authentication{

	public String registerUser(RegisterUserRequest registerUserRequest) {
		DataSingleton dataSingleton = DataSingleton.getDataObject();
		User user = new User();
		user.setFirstname(registerUserRequest.getFirstName());
		user.setLastname(registerUserRequest.getLastName());
		user.setTags(registerUserRequest.getTags());
		String userId = "u:"+String.valueOf(dataSingleton.getUserSequence());
		dataSingleton.setUserSequence(dataSingleton.getUserSequence() + 1);
		user.setUserId(userId);
		dataSingleton.getUserMap().put(user.getUserId(), user);
		return userId;
	}
	
}
