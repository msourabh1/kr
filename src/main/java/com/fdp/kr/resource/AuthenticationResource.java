package com.fdp.kr.resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fdp.kr.controller.Authentication;
import com.fdp.kr.controller.AuthenticationImpl;
import com.fdp.kr.request.RegisterUserRequest;

@Path("/auth")
public class AuthenticationResource {
	
	private Authentication authentication;
	
	public AuthenticationResource() {
		authentication = new AuthenticationImpl();
	
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registeUser(RegisterUserRequest registerUserRequest) {

		
		String userId = authentication.registerUser(registerUserRequest);
		return Response.status(200).entity(userId).build();

	}
}
