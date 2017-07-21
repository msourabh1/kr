package com.fdp.kr.controller;

import com.fdp.kr.request.RegisterUserRequest;

public interface Authentication {
	public String registerUser(RegisterUserRequest registerUserRequest);
}
